// Question :-  https://www.hackerearth.com/practice/data-structures/arrays/1-d/practice-problems/algorithm/tram-ride-d7ff3a92/

static long solve(int N, int start, int finish, int[] Ticket_cost){
       long result = 0;
       // Write your code here
       if(start == finish){
        return 0;
       }
       int temp = start-1;
       long sum1 = 0;
       long sum2 = 0;

       while(temp != finish-1){
        sum1 += Ticket_cost[temp];
        temp = (temp + 1) % N;
       }

       temp = (finish -1) % N;

       while(temp != start-1){
        sum2 += Ticket_cost[temp];
        temp = (temp + 1) % N;
       }
       result = Math.min(sum1, sum2);
       return result;
    
    }
