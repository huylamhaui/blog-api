package lamph11.api.service;

import lombok.AllArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegisterService {

    @EventListener(RegisterEvent.class)
    public void onRegister(RegisterEvent e){
        System.out.println(e.getCategory());
    }
}
