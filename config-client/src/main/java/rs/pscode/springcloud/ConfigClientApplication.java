package rs.pscode.springcloud;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@RestController
@RefreshScope
public class ConfigClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigClientApplication.class, args);
    }


    @Value(value = "${rs.pscode.value:Hello default}")
    private String value;

    @Value(value = "${rs.pscode.default:All Profiles}")
    private String valueDefault;

    @GetMapping(value = "/test")
    public ResponseEntity<Map<String, String>> test() {
        Map<String, String> map = new HashMap<>(2);
        map.put("value", value);
        map.put("valueDefault", valueDefault);

        return ResponseEntity.ok(map);
    }
}
