package service;

import java.util.List;
import java.util.Map;
import java.util.Set;
import model.Gender;
import model.People;
import model.Pet;

public interface PeopleService   {
    Map<Gender,Long> cnopbg(List<People> list); 
    List<People> numofpetmorethanone(List<People> list,int num);
    List<People> findByPetType(List<People> list,Pet petType);
    Gender mostHaveCat(List<People> list,Pet petType);
    boolean peopleNoPet(List<People> list);
    People yoengPeople(List<People> list);
    Set<Pet> findAppPets(List<People> list);
    Map<Integer,List<People>> groupByAge(List<People> list);
    Map<Boolean,List<People>> groupByAgeUpperThan18(List<People> list,Integer age);
    Map<Pet, List<String>> groupByPet(List<People> list);
    List<People> filterPeople(List<People> list);

}