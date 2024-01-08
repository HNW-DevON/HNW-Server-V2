package me.seula.greeny.service;

import lombok.RequiredArgsConstructor;
import me.seula.greeny.domain.QuestEntity;
import me.seula.greeny.dto.QuestDTO;
import me.seula.greeny.repository.QuestRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class QuestService {

    private final QuestRepository questRepository;

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
