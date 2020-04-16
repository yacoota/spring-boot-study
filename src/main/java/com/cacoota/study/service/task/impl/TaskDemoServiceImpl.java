package com.cacoota.study.service.task.impl;

import com.cacoota.study.service.task.TaskDemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TaskDemoServiceImpl implements TaskDemoService {

    @Scheduled(fixedRateString = "${study.task.hack.fixed}", initialDelayString = "${study.task.hack.init}")
    public void execute() {
        log.info("定时任务执行：{}", this);
    }

}
