package aston.demospring.service;

import aston.demospring.entity.Instrument;
import aston.demospring.repository.CornemuseRepo;
import aston.demospring.repository.GuitareRepo;
import aston.demospring.repository.PianoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InstrumentService {

    @Autowired
    private GuitareRepo guitareRepo;
    @Autowired
    private PianoRepo pianoRepo;
    @Autowired
    private CornemuseRepo cornemuseRepo;

    public List<Instrument> findAll() {
        List<Instrument> instrus = new ArrayList<Instrument>();
        instrus.addAll(this.guitareRepo.findAll());
        instrus.addAll(this.pianoRepo.findAll());
        instrus.addAll(this.cornemuseRepo.findAll());
        return instrus;
    }


}
