package pl.bykowski.restclient;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class JobClient {

    public Job[] getDataFromGitHubApi() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Job[]> exchange = restTemplate.exchange(
                "https://jobs.github.com/positions.json?description=java&location=berlin",
                HttpMethod.GET,
                HttpEntity.EMPTY,
                Job[].class
        );
        return exchange.getBody();
    }
}
