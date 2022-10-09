import java.util.List;
import java.util.Map;
import model.Gender;
import model.People;
import model.Pet;
import service.PeopleService;
import service.PeopleServiceIMP;

public class App {
    private final PeopleService peopleService = new PeopleServiceIMP();
    private final List<People> l_o_p = List.of(
            new People("khem", Gender.Male, 21, List.of(Pet.COW)),
            new People("khem", Gender.Female, 21, List.of(Pet.CAT, Pet.COW)),
            new People("khem", Gender.Male, 21, List.of(Pet.CAT)),
            new People("khem", Gender.Female, 21, List.of(Pet.CAT)),
            new People("khem", Gender.Male, 21, List.of(Pet.DOG)),
            new People("khem", Gender.Male, 21, List.of(Pet.CAT)),
            new People("khem", Gender.Female, 21, List.of(Pet.CAT)),
            new People("khem", Gender.Male, 21, List.of(Pet.FISH)),
            new People("khem", Gender.Male, 21, List.of(Pet.CAT)),
            new People("khem1", Gender.Female, 17, List.of(Pet.BRID)));

    public static void main(String[] args) throws Exception {
        App app = new App();
        app.showByGender();
        app.showPeopleHavePetMoreThanOne();
        app.showWhoHaveCat();
        app.showPeopleLikeCatMost();
        app.showPeoleNoPet();
        app.showPeopleYoung();

    }

    public void showByGender() {
        System.out.println("----------------------- show by gender--------------------------");
        Map<Gender, Long> cnopbg = peopleService.cnopbg(l_o_p);
        System.out.println(cnopbg);
    }

    public void showPeopleHavePetMoreThanOne() {
        System.out.println("---------------------------People have Pet more than One-----------------");
        List<People> numofpetmorethanone = peopleService.numofpetmorethanone(l_o_p, 1);
        numofpetmorethanone.forEach(peoples -> System.out.println(peoples.getName()));
    }

    public void showWhoHaveCat() {
        System.out.println("----------------------------Peopele who have cat------------------------");
        List<People> findByPetType = peopleService.findByPetType(l_o_p, Pet.CAT);
        findByPetType.forEach(p -> System.out.println(p.getName() + " :" + p.getPet()));
    }

    public void showPeopleLikeCatMost() {
        System.out.println("-----------------------------People Like Cat Most-----------------------------");
        Gender mostHaveCat = peopleService.mostHaveCat(l_o_p, Pet.CAT);
        System.out.println(mostHaveCat);
    }

    public void showPeoleNoPet() {
        System.out.println("--------------------people no pet---------------------------");
        boolean peopleNoPet = peopleService.peopleNoPet(l_o_p);
        System.out.println(peopleNoPet);
    }

    public void showPeopleYoung() {
        System.out.println("-----------------------------People Young Age-----------------------------");
        People yoengPeople = peopleService.yoengPeople(l_o_p);
        System.out.println(yoengPeople.getName());
    }
}