package tech.ready2devs.porftolio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.ready2devs.porftolio.model.Skills;
import tech.ready2devs.porftolio.repo.SkillsRepo;

import java.util.List;

@Service
@Transactional
public class SkillsService {

    private final SkillsRepo skillsRepo;

    @Autowired
    public SkillsService(SkillsRepo skillsRepo) {
        this.skillsRepo = skillsRepo;
    }


    public Skills addSkills(Skills ski) {
        return skillsRepo.save(ski);
    }

    public List<Skills> findAllSkills() {
        return skillsRepo.findAll();
    }

    public Skills updateSkills(Skills ski) {
        return skillsRepo.save(ski);
    }

    public Skills getOneSkills(Long id) {
        return skillsRepo.findById(id).orElse(null);
    }

    public void deleteSkills(Long id) {
        skillsRepo.deleteById(id);
    }

    public boolean existSkillsById(Long id){
        return skillsRepo.existsById(id);
    }




}
