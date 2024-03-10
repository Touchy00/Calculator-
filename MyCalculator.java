import java.util.Scanner;

public class MyCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);  //задается новое имя сканнера.Сканнер отправляет запрос/сигнал в терминал и ожидает ответа пользователя
        System.out.println("Введите значиние"); //приветствие для пользователя, чтобы пошла ответная реакция
        String line = sc.nextLine();
        calc(line);
    }
    static void calc(String input){
        String [] values = input.split(" ");
        if (values.length != 3){
            throw new NumberFormatException("Нельзя вводить больше 2 значений");
        }
        String value1 = values[0];   // получает значение которое ввожит пользователь
        String operator = values[1];
        String value2 = values[2];
        boolean isArab = false;   // флаг который указывает, что пользователь ввожил арабские числа
        int res = 0;// переменная в которую помещаем результат сложения, умножения, деления, вычитания
        int num1;
        int num2;
        MyCalculator m = new MyCalculator(); //создается экземпляр класса что бы вызывать методы transrim, transArab
        num1 = m.transrim(value1); //переводит из римской цифры в  арабскую  1=I, 2=II, если нет такой римской цифры возрвщвет 0
        num2 = m.transrim(value2);
        if (num1 == 0 | num2 == 0) { //если value1 или value2 не римское число, то n1 или n2 равно 0
            if (value1.matches("\\d+") && value2.matches("\\d+")) { //весь код, который может вызвать исключения,находится в блоке трай
                num1 = Integer.parseInt(value1); //переводит из прописной стринг(например "2") в интовую (2)
                num2 = Integer.parseInt(value2); //переводит из прописной стринг(например "2") в интовую (2)
                isArab = true; // ответ-числовой если фолс-ответ римскими

            } else{ // елли value1 value2 не арабское число (напмире "Даша / Маша")
                throw new NumberFormatException(value1 + " или " + value2 + " не является арабской цифрой !");
            }
        }
        if (num1 >=1 && num1 <=10 && num2 >=1 && num2 <=10) {//условия калькулятора(1-10)будут работать только, в рамках одновременного обязательства
            if (operator.equals("+")){//проверка подлинности(эклз проверяет) что плюс-это плюс
                res = num1+num2;//под каждым оператором, прописываем соответстующий (res)результат, его работы
            }
            if (operator.equals("-")){
                res = num1-num2;
            }
            if (operator.equals("*")){
                res = num1*num2;
            }
            if (operator.equals("/")){
                res = num1/num2;
            }
        }else{ //если (if) не подходит, тогда сработает (else) иначе,которое выведет рпботу кода в асболютный ответ/тупик
            throw new NumberFormatException("Так делать не нааадо. Можно от 1-10");
        }
        if (isArab){//проверка на арабское число имеет значение что было
            System.out.println(res); //печатает соответствующий арабский ответ
        }else { //если исараб-фолс то печатает римский ответ
            if(res > 0) {
                String resArab = m.transArab(res); // Переводит из арбского в римское число
                System.out.println(resArab); // Печатает РИМСКИЙ ответ
            }else {
                throw new ArrayIndexOutOfBoundsException("Отрицательных римских значений не существует ");
            }
        }

    }
    int transrim(String rim) {
        String[] slova = new String[] {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        int count2 = 0;
        while (count2 <slova.length) {
            if (slova[count2].equals(rim)){
                return count2 += 1;
            }
            count2++;
        }
        return 0;
    }
    String transArab(int res) {
        String[] slova = new String[] {
                "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X",
                "XI","XII","XIII","XIV","XV","XVI","XVII","XVIII","XIX","XX",
                "XXI","XXII","XXIII","XXIV","XXV","XXVI","XXVII","XXVIII","XXIX","XXX",
                "XXXI","XXXII","XXXIII","XXXIV","XXXV","XXXVI","XXXVII","XXXVIII","XXXIX","XL",
                "XLI","XLII","XLIII","XLIV","XLV","XLVI","XLVII","XLVIII","XLIX","L",
                "LI","LII","LIII","LIV","LV","LVI","LVII","LVIII","LIX","LX",
                "LXI","LXII","LXIII","LXIV","LXV","LXVI","LXVII","LXVIII","LXIX","LXX",
                "LXXI","LXXII","LXXIII","LXXIV","LXXV","LXXVI","LXXVII","LXXVIII","LXXIX","LXXX",
                "LXXXI","LXXXII","LXXXIII","LXXXIV","LXXXV","LXXXVI","LXXXVII","LXXXVIII","LXXXIX","XC",
                "XCI","XCII","XCIII","XCIV","XCV","XCVI","XCVII","XCVIII","XCIX","C",
        };
        return slova[res - 1];
    }
}