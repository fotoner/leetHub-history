class Solution {
    public int[] countMentions(int numberOfUsers, List<List<String>> events) {
        int[] userOnline = new int[numberOfUsers]; 
        int[] callCount = new int[numberOfUsers];
        
        events.sort((e1, e2)-> {
            String[] arr1 = e1.toArray(new String[e1.size()]);
            String[] arr2 = e2.toArray(new String[e1.size()]);
            int t1 = Integer.parseInt(arr1[1]);
            int t2 = Integer.parseInt(arr2[1]);
            
            if(t1 == t2) {
                t1 = arr1[0].equals("MESSAGE")? 987654321: 0;
                t2 = arr2[0].equals("MESSAGE")? 987654321: 0;
            }

            return t1 - t2;
        });
        
        for(List<String> event: events) {
            String[] arr = event.toArray(new String[event.size()]);

            String type = arr[0];
            int timestamp = Integer.parseInt(arr[1]);
            String msg = arr[2];
            
            if(type.equals("MESSAGE")) {
                if(msg.equals("ALL")) {
                    for(int i = 0; i < numberOfUsers; i++) {
                        callCount[i]++;
                    }
                } else if (msg.equals("HERE")) {
                    for(int i = 0; i < numberOfUsers; i++) {
                        int state = userOnline[i];
                        if(state <= timestamp) 
                            callCount[i]++;
                    }
                } else {
                    for (String call: msg.split(" ")){
                        int calledUser = Integer.parseInt(call.substring(2));

                        callCount[calledUser]++;
                    }
                }
            } else {
                int offUser = Integer.parseInt(msg);
                userOnline[offUser] = 60 + timestamp;
            }
        }

        return callCount;
    }
}