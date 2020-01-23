package demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SentenceService {

    @Autowired
    private WordService wordService;

    public String buildSentence() {
        return String.format("%s %s.",
                wordService.getSubject().getString(), wordService.getVerb().getString());
    }

}
