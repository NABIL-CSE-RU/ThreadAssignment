
import java.util.ArrayList;
import java.util.List;
public class ArrayCorruptedList {
    public static void main(String[] args)  throws IndexOutOfBoundsException{
        List <Integer> list = new ArrayList<>();

              Runnable addNumber = () -> {
                  for (int i = 1; i <= 50; i++) {
                      list.add(i);

                  }
              };

              Runnable removeNumber = () -> {
                  for (int i = 1; i <= 25; i++) {
                      if (!list.isEmpty()) {
                          list.remove(i);

                      }
                  }
              };


              Thread add = new Thread(addNumber);
              Thread remove = new Thread(removeNumber);

        add.start();
        remove.start();
       try {
           add.join();
           remove.join();
       }
        catch (InterruptedException e) {
           throw new RuntimeException(e);
       } ;
        System.out.println("Size : " + list.size());
        System.out.println("List : " + list);

    }
}
