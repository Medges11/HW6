import java.util.Objects;
import java.util.Scanner;

public class Phone {
    private Contact[] contacts = new Contact[10];

    private void ShowContacts() {
        for (int i = 0; i < 10; i++) {
            if (contacts[i] != null) {
                System.out.println(i + 1 + ". " + contacts[i].GetName() + " " + contacts[i].GetValue());
            } else {
                System.out.println(i + 1 + ". " + "...");
            }
        }
    }
    private void NewContact() {
        Scanner scanner = new Scanner(System.in);
        String name = "";
        String value = "";
        System.out.println("Введите имя: ");
        name = scanner.next();

        while (name.isEmpty()) {
            name = scanner.next();
            if (name.isEmpty()) {
                System.out.println("Поле не должно быть пустым");
            }
        }

        System.out.println("Введите номер телефона: ");
        while (value.isEmpty()) {
            value = scanner.next();
            if (value.isEmpty()) {
                System.out.println("Поле не должно быть пустым");
            }
        }

        for (int i = 0; i < 10; i++) {
            if (i == 9 && contacts[i] != null) {
                System.out.println("Превышено максимальное число пользователей");
            }

            if (contacts[i] != null) {
                continue;
            }

            contacts[i] = new Contact(name, value);
            break;
        }

        ShowContacts();
    }

    private void ChangeContact() {
        Scanner scanner = new Scanner(System.in);
        String stringIndex = "";
        String name = "";
        String value = "";
        int index = 0;

        System.out.println("Введите индекс контакта, который вы хотите изменить");
        while (stringIndex.isEmpty()) {
            stringIndex = scanner.next();
            if (stringIndex.isEmpty()) {
                System.out.println("Поле не должно быть пустым");
            } else {
                index = Integer.parseInt(stringIndex);
            }
        }

        System.out.println("Введите новое имя для контакта");
        while (name.isEmpty()) {
            name = scanner.next();
            if (name.isEmpty()) {
                System.out.println("Поле не должно быть пустым");
            }
        }

        System.out.println("Введите новое значение для контакта");
        while (value.isEmpty()) {
            value = scanner.next();
            if (value.isEmpty()) {
                System.out.println("Поле не должно быть пустым");
            }
        }

        contacts[index].SetName(name);
        contacts[index].SetValue(value);
        ShowContacts();
    }

    private void DeleteContact() {
        Scanner scanner = new Scanner(System.in);
        String stringIndex = "";
        int index = 0;

        System.out.println("Введите индекс контакта, который вы хотите изменить");
        while (stringIndex.isEmpty()) {
            stringIndex = scanner.next();
            if (stringIndex.isEmpty()) {
                System.out.println("Поле не должно быть пустым");
            } else {
                index = Integer.parseInt(stringIndex);
            }
        }

        contacts[index] = null;
        ShowContacts();
    }

    private void Exit() {
        System.exit(0);
    }


    private String ReadCommand() {
        Scanner scanner = new Scanner(System.in);
        String command = "";
        while (command.isEmpty()) {
            command = scanner.next();
            if (command.isEmpty()) {
                System.out.println("Поле не должно быть пустым");
            }
        }
        return command;
    }
    public void Run() {
        while (true) {
            System.out.println("---МЕНЮ---");
            System.out.println("Введите номер команды:");
            System.out.println("1. Добавить контакт");
            System.out.println("2. Изменить контакт");
            System.out.println("3. Удалить контакт");
            System.out.println("4. Сохранить и выйти");


            String command = "";
            while (true) {
                command = ReadCommand();
                if (Objects.equals(command, "1") | Objects.equals(command, "2") | Objects.equals(command, "3") | Objects.equals(command, "4")) {
                    break;
                }
            }

            if (command.equals("1")) {
                NewContact();
            } else if (command.equals("2")) {
                ChangeContact();
            } else if (command.equals("3")) {
                DeleteContact();
            } else if (command.equals("4")) {
                Exit();
            } else {
                System.out.println("Неизвестная комманда");
            }
        }
    }
}
