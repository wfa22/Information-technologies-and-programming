import java.util.EmptyStackException;

public class Print {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>(7);

        try {
            stack.push(1);
            stack.push(2);
            stack.push(3);

            stack.printStack();

            System.out.println(stack.pop());
            System.out.println(stack.peek());

            stack.push(4);
            System.out.println(stack.pop());

            stack.printStack();

            System.out.println(stack.pop());
            System.out.println(stack.peek());

            stack.printStack();

        } catch (EmptyStackException e) {
            System.out.println("Ошибка: Попытка извлечь элемент из пустого стека.");
        } catch (StackOverflowError e) {
            System.out.println("Ошибка: Стек переполнен.");
        } catch (Exception e) {
            System.out.println("Произошла непредвиденная ошибка: " + e.getMessage());
        }
    }
}