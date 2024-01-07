package me.seula.hnw.service;

import me.seula.hnw.domain.QuestEntity;
import me.seula.hnw.dto.QuestDTO;
import me.seula.hnw.repository.QuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestService {

    private final QuestRepository questRepository;

    @Autowired
    public QuestService(QuestRepository questRepository) {
        this.questRepository = questRepository;
    }

    public List<QuestEntity> getQuestList() {
        return questRepository.findAll();
    }

    public QuestEntity getQuest(int questId) {
        return questRepository.findById(questId);
    }

    public void createQuest(QuestDTO questDTO) {
        String questName = questDTO.getQuestName();
        String questDesc = questDTO.getQuestDesc();

        QuestEntity questEntity = new QuestEntity();

        questEntity.setQuestName(questName);
        questEntity.setQuestDesc(questDesc);

        questRepository.save(questEntity);
    }
}
