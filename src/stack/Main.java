package stack;

public class Main {
	public static void main(String[] args) {
//		Stack<String> stack = new Stack<String>();
//		stack.push("1");
//		stack.push("2");
//		stack.push("3");
//		stack.push("4");
//		stack.push("5");
//		stack.pop();
//		stack.pop();
//		System.out.println(stack);
		
		Calculator cal = new Calculator();
		int result = cal.calculate("1+22*3/2+3*3");
		System.out.println(result);
		
	}
}
