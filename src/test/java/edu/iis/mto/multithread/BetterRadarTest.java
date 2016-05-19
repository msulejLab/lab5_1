package edu.iis.mto.multithread;

import org.junit.Test;

import java.util.concurrent.Executor;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class BetterRadarTest {
    @Test
    public void testLauncherInTheSameThread() {
        PatriotBattery batteryMock = mock(PatriotBattery.class);
        Executor executor = new Executor() {
            @Override
            public void execute(Runnable runnable) {
                runnable.run();
            }
        };
        BetterRadar radar = new BetterRadar(batteryMock, executor);

        radar.notice(new Scud());

        verify(batteryMock, times(10)).launchPatriot();
    }
}
