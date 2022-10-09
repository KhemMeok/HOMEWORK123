package service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import model.Gender;
import model.People;
import model.Pet;

public class PeopleServiceIMP implements PeopleService {

    @Override
    public Map<Gender, Long> cnopbg(List<People> list) {
        return list.stream()
                .collect(Collectors.groupingBy(People::getGender, Collectors.counting()));

    }

    @Override
    public List<People> numofpetmorethanone(List<People> list, int num) {
        return list.stream()
                .filter(p -> p.getPet().size() > num)
                .collect(Collectors.toList());

    }

    @Override
    public List<People> findByPetType(List<People> list, Pet petType) {
        return list.stream()
                .filter(p -> p.getPet().contains(petType))
                .collect(Collectors.toList());

    }

    @Override
    public Gender mostHaveCat(List<People> list, Pet petType) {
        Map<Gender, Long> cnopbg = cnopbg(list);
        Long numOfMale = cnopbg.get(Gender.Male);
        Long numOfFemale = cnopbg.get(Gender.Female);

        List<People> peopleHaveCat = findByPetType(list, Pet.CAT);
        Map<Gender, Long> mapByGenderPeopleHaveCat = cnopbg(peopleHaveCat);

        Long numMaleHaveCat = mapByGenderPeopleHaveCat.get(Gender.Male);
        Long numFemaleHaveCat = mapByGenderPeopleHaveCat.get(Gender.Female);

        double mp = numMaleHaveCat / numOfMale;
        double fp = numFemaleHaveCat / numOfFemale;

        return mp > fp ? Gender.Female : Gender.Male;
    }

    @Override
    public boolean peopleNoPet(List<People> list) {
        return list.stream()
                .anyMatch(p -> p.getPet().isEmpty());

    }

    @Override
    public People yoengPeople(List<People> list) {
        return list.stream().min((a, b) -> a.getAge() - b.getAge()).get();

    }

}
