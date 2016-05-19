package edu.iis.mto.multithread;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

public class BetterRadar  {
    private PatriotBattery battery;

    private Executor executorService;

    private ThreadPoolExecutor threadExecutor;

    public BetterRadar(PatriotBattery battery, Executor executorService) {
        this.battery = battery;
        this.executorService = executorService;;
    }

    public void notice(Scud enemyMissle) {
        launchPatriot();
    }

    private void launchPatriot() {
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    battery.launchPatriot();
                }
            }
        });
    }
}
