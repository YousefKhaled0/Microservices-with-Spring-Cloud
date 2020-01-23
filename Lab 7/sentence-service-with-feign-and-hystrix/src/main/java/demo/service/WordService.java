package demo.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import demo.dao.SubjectClient;
import demo.dao.VerbClient;
import demo.domain.Word;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WordService {

    @Autowired
    private VerbClient verbClient;

    @Autowired
    private SubjectClient subjectClient;

    @HystrixCommand(fallbackMethod = "getFallbackSubject")
    public Word getSubject() {
        return new Word(subjectClient.getSubject());
    }

    @HystrixCommand(fallbackMethod = "getFallbackVerb")
    public Word getVerb() {
        return new Word(verbClient.getVerb());
    }

    public Word getFallbackSubject() {
        return new Word("Someone");
    }

    public Word getFallbackVerb() {
        return new Word("Saw");
    }

}
