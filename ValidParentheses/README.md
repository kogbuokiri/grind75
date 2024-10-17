# Intuition
I first came up with a solution that ensures that an open bracket has a closing bracket - of the same type - to coorespond to it. 
Put simply, I used a Hashmap storing an open bracket (key) & count (value). 
1. If we reach an open bracket in string we add to count 
2. If we reach a closed bracket in string we subtract from count
3. If $$count=0$$ when we reach a closed bracket we return false
4. If all counts are 0 at the end return true, otherwise false

However, this does not represent valid parenthises based on the problem. 

The problem states that they need to be closed in the _correct order_. That order is shown in the cases provided.
``` java []
class Solution {
    public boolean isValid(String s) {  
        //base case 
        if(s.length()<2) return false;

        //variables
       // int count= 0
        //int count1 =  
        HashMap <Character, Integer> map = new HashMap<>();
        map.put('(',0);
        map.put('[',0);
        map.put('{',0);
    
        for(int i = 0; i<s.length();i++){
            if(s.charAt(i)==')'){
                if(s.charAt(i)==')' && (map.get('(')==0)){
                    return false;
                }
                else{
                    int count = map.get('(');
                    map.replace('(', count -1);
                }
            }
            else if (s.charAt(i)==']'){
                if(s.charAt(i)==']' && (map.get('[')==0)){
                    return false;
                }
                else{
                    int count = map.get('[');
                    map.replace('[', count -1);
                }
            }
            else if (s.charAt(i)=='}'){
                if(s.charAt(i)=='}' && (map.get('{')==0)){
                    return false;
                }
                else{
                    int count = map.get('{');
                    map.replace('{', count -1);
                }
                
            }
            else{
                if(s.charAt(i)=='('){
                    int count = map.get('(');
                    map.replace('(', count +1);
                }
                else if (s.charAt(i)=='['){
                    int count = map.get('[');
                    map.replace('[', count +1);
                }
                else{
                    int count = map.get('{');
                    map.replace('{', count +1);
                }
            }      
            }
            if(map.get('[')==0 && map.get('(')== 0 && map.get('{') ==0) return true;
            return false;
            }
        }
        
```
*For example: Solution is invalid when $$s= "([)]"$$
# Approach
<!-- Describe your approach to solving the problem. -->
- In this approach (Shown in _Code_ section) we keep the base case (if ($$len(s)<2$$): return false). But this time we take a stack approach. By using a stack we can make sure the brackets are in the _correct order_.

 
(e.g. string = "[()])
- [x] Create a stack
- [ ] If-statement to check if stack is Empty and the bracket is a closing bracket. This is false (We start with ']').
- [x] Otherwise, bunch of if-statments to check if the bracket is open. In this case. Yes. So we add to stack. stack = ['['].
- [x] Move on.
- [x] Next is '['
- [x] Skip if-statement. We add to stack again. stack = ['(','[']
- [x] Skip if-statement. We are not in a case were we are checking for closed-open bracket order. Since we have ')' we have an if-statment that checks whether or not the latest parenthesis corresponds to this. Perform stack.pop() = '('. This is true. 
- [x] Move on.
- [x] Skip if-statement. We are not in a case were we are checking for closed-open bracket order. Since we have ']' we have an if-statment that checks whether or not the latest bracket corresponds to this. Perform stack.pop() = '['. This is true.
- [x] Leave for loop
- [x] Return true. Since stack is empty

# Complexity
- Time complexity:
$$O(n)$$

- Space complexity:
$$O(n)$$

# Code
```java []
class Solution {
    public boolean isValid(String s) {
        /*
        Stack: 
        This would not work because first and last element would not match
        Would need to make a stack for each element and write an if statement to check if it is 0 or 1 item

        Set: 
        This would not work because you are not really looking for duplicates

        HashMap: 
        check if hashmap count is 0 for ) return false
        two counts

        if found ) subtract 1 from the count
        key: (  value: count
        */
        
        //base case 
        if(s.length()<2) return false;

        //variables
       // int count= 0
        //int count1 =
        Stack <Character> stack = new Stack<>();

        for(int i =0; i<s.length();i++){
            if(stack.isEmpty() &&((s.charAt(i)=='}')||(s.charAt(i)==')')||(s.charAt(i)==']'))) return false;
            else{
                if(s.charAt(i)=='{'){
                    stack.add('{');
                }
                else if(s.charAt(i)=='('){
                    stack.add('(');
                }
                else if(s.charAt(i)=='['){
                    stack.add('[');
                }
                else if(s.charAt(i)==')'){
                    if(stack.pop()!= '(') return false;
                    else{
                        continue;
                    } 
                    
                }
                else if(s.charAt(i)==']'){
                    if(stack.pop()!= '[') return false;
                    else{
                        continue;
                    } 
                }
                else{
                    if(stack.pop()!= '{') return false;
                    else{
                        continue;
                    } 
                }
            }
        }
        if(stack.isEmpty()) return true;

        return false;

        
    }
}
        
```
