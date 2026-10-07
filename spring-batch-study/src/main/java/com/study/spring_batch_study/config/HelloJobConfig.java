package com.study.spring_batch_study.config;


import com.study.spring_batch_study.tasklet.HelloTasklet;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.job.Job;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.Step;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@RequiredArgsConstructor
public class HelloJobConfig {

    private final JobRepository jobRepository;
    private final PlatformTransactionManager transactionManager;
    private final HelloTasklet helloTasklet;

    @Bean
    public Job helloJob() {

        return new JobBuilder("helloJob", jobRepository)
                .start(helloStep())
                .build();
    }

    @Bean
    public Step helloStep() {

        return new StepBuilder("helloStep", jobRepository)
                .tasklet(helloTasklet, transactionManager)
                .build();
    }
}
