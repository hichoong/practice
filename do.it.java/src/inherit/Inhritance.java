package inherit;

class Human{
        String name;
        int age;
        void eat() {}
        void sleep() {}
    }
    class Student extends Human {
            int StudentID;
            void goToSchool() {}
    }
    class Worker extends Human{
            int workerID;
            void goToWork(){}
    }
    public class Inhritance {
    public static void main(String[] args) {

        Human h = new Human();
        h.name = "김충희";
        h.age = 28;
        h.eat();
        h.sleep();

        Student s = new Student();
        s.name = "김충희2";
        s.age = 26;
        s.StudentID = 128;
        s.eat();
        s.sleep();
        s.goToSchool();

        Worker w = new Worker();
        w.name = "김충희3";
        w.age = 30;
        w.workerID = 123;
        w.eat();
        w.sleep();
        w.goToWork();

    }
}

