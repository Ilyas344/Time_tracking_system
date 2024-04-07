package t1academy.timetrackingsystem.service.impl;

import org.springframework.stereotype.Service;
import t1academy.timetrackingsystem.aspect.annotation.TrackAsyncTime;
import t1academy.timetrackingsystem.aspect.annotation.TrackTime;
import t1academy.timetrackingsystem.service.TestService;

@Service
public class TestServiceImpl implements TestService {

    @Override
    @TrackTime
    public void testTime() {
        int random = (int) (Math.random() * 10);
        for (int i = 0; i < random; i++) {
            System.out.println(i);
        }
    }

    @TrackAsyncTime
    @Override
    public void testAsyncTime() {
        int random = (int) (Math.random() * 10);
        for (int i = 0; i < random; i++) {
            System.out.println(i);
        }

    }
}
