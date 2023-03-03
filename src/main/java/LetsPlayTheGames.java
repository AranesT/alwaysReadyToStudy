import java.util.*;

public class LetsPlayTheGames {

    /**
     * Ваша задача - реализовать класс, в котором буду находиться игры, в которые пользователь сможет сыграть.
     * Главная задача - сделать его легко масштабируемым, т.е. иметь возможность легко увеличить количество
     * доступных игр.
     */
    private static HashMap<Integer, String> nameOfGame = new HashMap<>();
    static Scanner scanner = new Scanner(System.in);

    //Ввести переменную для выбора игры повторно
    public static void main(String[] args) {
        start();
    }

    public static void start() {
        System.out.println("Приветсвую, давай сыграем в игру! Сделай свой выбор: ");
        listOfMap();
        while (true) {
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    verbalCounting();
                    break;
                case "2":
                    System.out.println("Пока в разработке");
                    break;
                default:
                    System.out.println("Вы ввели некорректное значение. Попрбуйте снова: ");
            }
        }
    }


    public static void verbalCounting() {
        System.out.println("Цель этой игры - ввести верный результат. Помните, оперции выполняются последовательно!" + "\n" + "Поехали!");
        int level = 2;
        int countOfLife = 3;
        int countOfResult = 0;
        int number;
        String mathematicalExpression;
        Random random = new Random();
        int numberEndsForRandom = 1;
        while (countOfResult <= 4 && countOfLife != 0) {
            int[] arrayOfNumbers = new int[level];
            for (int i = 0; i < arrayOfNumbers.length; i++) {
                arrayOfNumbers[i] = random.nextInt(10 * numberEndsForRandom);
            }
            number = arrayOfNumbers[0];
            mathematicalExpression = String.valueOf(arrayOfNumbers[0]);
            for (int j = 1; j < arrayOfNumbers.length; j++) {
                int numberOfMathSings = random.nextInt(3);
                switch (numberOfMathSings) {
                    case 0:
                        number = number + arrayOfNumbers[j];
                        mathematicalExpression = mathematicalExpression + "+" + arrayOfNumbers[j];
                        break;
                    case 1:
                        number = number - arrayOfNumbers[j];
                        mathematicalExpression = mathematicalExpression + "-" + arrayOfNumbers[j];
                        break;
                    case 2:
                        number = number * arrayOfNumbers[j];
                        mathematicalExpression = mathematicalExpression + "*" + arrayOfNumbers[j];
                        break;
                }
            }
            System.out.println(mathematicalExpression+ "\nВведите ваш ответ: ");
            String answer;
            boolean goodMinus;
            do {
                answer = scanner.nextLine();
                if (answer.contains("-")) goodMinus = (answer.startsWith("-")) && (answer.replace("-", "").length() == answer.length() - 1);
                else goodMinus = true;
                if (!(answer.replaceAll("[\\D][\\^-]", "").length() == answer.length() && goodMinus))
                    System.out.println("Вы ввели некорректное значение. Введите ответ.");

            } while (!(answer.replaceAll("[\\D]+[\\^-]", "").length() == answer.length() && goodMinus));
            if (answer.equals(String.valueOf(number))) {
                countOfResult = countOfResult + 1;
                System.out.println("Верно!");
                if (countOfResult == 5) {
                    System.out.println("Уровень игры повышается!");
                    level ++;
                    countOfResult = 0;
                    countOfLife = 3;
                    numberEndsForRandom ++;
                }
            } else {
                if (countOfLife > 0)
                    countOfLife --;
                System.out.println("Ваш ответ неверный. Верный ответ " + number + "\n" +
                        "Потеряна одна жизнь. Текущее количество жизней " + countOfLife);
                if (countOfLife == 0) {
                    System.out.println("Потеряна последняя жизнь. Игра окончена! Что желаете?");
                    turnNext();
                }
            }
        }
    }


    public static void listOfMap() {
        nameOfGame.put(1, "Устный счет");
        nameOfGame.put(2, "Кости");
        nameOfGame.forEach((s1, s2) -> System.out.println(s1 + " - " + s2));
    }

    public static void turnNext() {
        System.out.println("1 - начать снова, 2 - выйти в меню, 3 - покончить с этими играми!");
        while (true) {
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    verbalCounting();
                    break;
                case "2":
                    start();
                    break;
                case "3":
                    System.out.println("Адьёс амигос!");
                    System.exit(100);
                default:
                    System.out.println("Вы ввели некорректное значение. Введите ответ.");
            }
        }
    }
}