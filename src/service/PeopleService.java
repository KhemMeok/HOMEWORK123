package service;

import java.util.List;
import java.util.Map;

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

}