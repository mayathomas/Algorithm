package stack;

public class Calculator {
	
	/**
	 * 操作符栈
	 */
	Stack<String> operatorStack;
	
	/**
	 * 操作数栈
	 */
	Stack<String> operandStack;
	
	public Calculator() {
		
		operandStack = new Stack<String>();
		operatorStack = new Stack<String>();
	}
	
	public int calculate(String expression) {
		char[] expressArr = expression.toCharArray();
		for(int i = 0; i < expressArr.length; i++) {
			if(expressArr[i] == '+' || expressArr[i] == '-') {
				operatorStack.push(String.valueOf(expressArr[i]));
			} else if(expressArr[i] == '*' || expressArr[i] == '/'){
				operatorStack.push(String.valueOf(expressArr[i]));
			} else {
				String digit = String.valueOf(expressArr[i]); 
				if(i < expressArr.length - 1) {
					for(int j = i + 1; j < expressArr.length; j++) {
						if(isDigit(expressArr[j])) {
							digit += expressArr[j];
							i++;
						} else {
							break;
						}
					}
				}
				operandStack.push(digit);
				
				//当操作数栈有值时，判断操作符栈栈顶是否为高优先级（/ *）符号，如果有，先计算值再压入操作数栈，并消耗掉操作符栈顶元素
				if(!operatorStack.isEmpty()) {
					String top = operatorStack.peek();
					if(("*".equals(top) || "/".equals(top))){
						top = operatorStack.pop();
						String a = operandStack.pop();
						String b = operandStack.pop();
						if("*".equals(top)) {
							int c = Integer.parseInt(b) * Integer.parseInt(a);
							operandStack.push(String.valueOf(c));
						}
						if("/".equals(top)) {
							int c = Integer.parseInt(b) / Integer.parseInt(a);
							operandStack.push(String.valueOf(c));
						}
					}
				}
			}
		}
		
		String operand;
		while((operand = operatorStack.pop()) != null) {
			String a = operandStack.pop();
			String b = operandStack.pop();
			if("+".equals(operand)) {
				int c = Integer.parseInt(b) + Integer.parseInt(a);
				operandStack.push(String.valueOf(c));
			}
			if("-".equals(operand)) {
				int c = Integer.parseInt(b) - Integer.parseInt(a);
				operandStack.push(String.valueOf(c));
			}
		}
		return Integer.parseInt(operandStack.pop());
	}	
	
	private boolean isDigit(char c) {
		return c == '0' || c == '1' || c == '2' || c == '3' || c == '4' || c == '5' || c == '6' || c == '7' || c == '8' || c == '9';
	}

}
