package edu.iu.camfraiz.historyservice.rabbitmq;

import com.google.gson.Gson;
import edu.iu.camfraiz.historyservice.model.PrimesRecord;
import edu.iu.camfraiz.historyservice.repository.PrimesHistoryRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class MQReceiver {

    private final PrimesHistoryRepository primesHistoryRepository;
    public MQReceiver(PrimesHistoryRepository primesHistoryRepository) {
        this.primesHistoryRepository = primesHistoryRepository;
    }

    @RabbitListener(queues = {"primes"})
    public void recieveMessage(@Payload String message) {
        System.out.println(message);
        Gson gson = new Gson();
        PrimesRecord primesRecord = gson
                .fromJson(message, PrimesRecord.class);
        primesHistoryRepository.save(primesRecord);
    }
}