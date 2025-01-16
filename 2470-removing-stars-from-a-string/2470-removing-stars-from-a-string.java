class Solution {
    public String removeStars(String s) {
        StringBuilder builder = new StringBuilder();
        
        for (String curValue: s.split("")){
            if(curValue.equals("*") && !builder.isEmpty()) {
                builder.deleteCharAt(builder.length() - 1);
            } else {
                builder.append(curValue);
            }
        }
        
        return builder.toString();
    }
}