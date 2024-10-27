package view;

import model.Car;
import model.User;
import service.MainService;
import utils.MyList;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    private final MainService service;
    private final Scanner scanner = new Scanner(System.in);

    public Menu(MainService service) {
        this.service = service;
    }

    public void run() {
        showMenu();
    }

    private void showMenu() {
        while (true) {
            System.out.println("Добро пожаловать в меню");
            System.out.println("1. Меню автомобилей");
            System.out.println("2. Меню пользователей");
            System.out.println("3. Меню администратора");
            System.out.println("0. Выход из системы");
            System.out.print("Введите пункт меню: ");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); // Очищаем сканер

                if (choice == 0) {
                    System.out.println("До свидания");
                    System.exit(0); // завершает приложение
                } else {
                    showSubMenu(choice);
                }
            } catch (InputMismatchException e) {
                System.out.println("Ошибка ввода! Пожалуйста, введите номер пункта меню.");
                scanner.nextLine(); // Очищаем сканер после некорректного ввода
            }
        }
    }


    private void showSubMenu(int choice) {
        switch (choice) {
            case 1:
                System.out.println("Метод showCarMenu() в разработке.");
                waitRead();
                break;
            case 2:
                showUserMenu();
                break;
            case 3:
                System.out.println("Метод showAdminMenu() в разработке.");
                waitRead();
                break;
            default:
                System.out.println("Некорректный выбор, попробуйте снова.");
        }
    }

    private void showCarMenu() {
        // TODO: add variants
        while (true) {
            System.out.println("Меню авто");
            System.out.println("1. Показать автомобили в наличии");
            System.out.print("Сделайте выбор пункта меню: ");
            int input = scanner.nextInt();
            scanner.nextLine();

            if (input == 0) break;

            handleCarMenuChoice(input);
        }
    }

    private void handleCarMenuChoice(int input) {
        switch (input) {
            case 1:
                MyList<Car> cars = service.getAllCars();
                for (Car car: cars) {
                    System.out.println(car);
                }
                waitRead();
            default: break;
        }
    }

    private void showUserMenu() {
        while (true) {
            System.out.println("Меню пользователя");
            System.out.println("1. Вход в систему");
            System.out.println("2. Регистрация нового пользователя");
            System.out.println("3. Выход из системы");
            System.out.println("0. Вернуться в предыдущее меню");
            System.out.print("Сделайте выбор пункта меню: ");
            int input = scanner.nextInt();
            scanner.nextLine();

            if (input == 0) break;

            handleUserMenuChoice(input);
        }
    }

    private void handleUserMenuChoice(int input) {
        switch (input) {
            case 1:
                System.out.println("Метод разработки. Приходите завтра");
                waitRead();
                break;
            case 2:
                System.out.print("Введите email: ");
                String email = scanner.nextLine();
                System.out.print("Введите пароль: ");
                String password = scanner.nextLine();

                User user = service.registerUser(email, password);
                if (user != null) {
                    System.out.println("Вы успешно зарегистрировались в системе");
                } else {
                    System.out.println("Регистрация провалена!");
                }
                waitRead();
                break;
            case 3:
                service.logout();
                System.out.println("Вы вышли из системы");
                waitRead();
                break;
            default:
                System.out.println("Неверный ввод, попробуйте снова.");
        }
    }

    private void waitRead() {
        System.out.println("Для продолжения нажмите Enter");
        scanner.nextLine();
    }
}
