import repository.CarRepository;
import repository.CarRepositoryImpl;
import repository.UserRepository;
import repository.UserRepositoryImpl;
import service.*;
import view.Menu;

public class CarsApp {
    public static void main(String[] args) {
        CarRepository carRepository = new CarRepositoryImpl();
        UserRepository userRepository = new UserRepositoryImpl();
        CarService carService = new CarServiceImpl(carRepository);
        UserService userService = new UserServiceImpl(userRepository);
        MainService service = new MainServiceImpl(carService, userService);
        Menu menu = new Menu(service);
        menu.run();
    }
}
