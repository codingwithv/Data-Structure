class Solution {
    class Pair{
        public int plantTime;
        public int growTime;

        Pair(int plantTime, int growTime){
            this.plantTime = plantTime;
            this.growTime = growTime;
        }
    }
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        int n = plantTime.length;
        Pair[] flowerPair = new Pair[n];

        for(int i = 0; i < n; i++){
            flowerPair[i] = new Pair(plantTime[i], growTime[i]);
        }
               
        // sort the grow_plant_times of seeds by their growTime in descending order. 
        // It makes sense to plant the seed with maximum growTime first
        //sort according to grow time (in descending order)
        Arrays.sort(flowerPair, (a,b) -> b.growTime - a.growTime);

        // a seed is planted only after the seeds having greater bloom time than the current seed are planted. 
        // So essentially, the plant time of a seed is the sum of plant times of all the seeds preceeding this seed 
        // and the plant time of the seed itself
        // we store the plant time of preceeding seeds in the following variable, prevPlantDays

        int prevPlantDays = 0;
        int maxBloomDays = 0;

        for(Pair current : flowerPair){
            // adding the plant time of ith seed to the plant times of preceeding seeds 
            // it would take prev_plant_time amount of time to actually plant the ith seed
            prevPlantDays += current.plantTime;

            // bloom time of ith seed = total plant time of ith seed + grow time of ith seed + 1 
            // (as the flower blooms after last day of it's growth)

            int currPlantBloomTime = prevPlantDays + current.growTime;
            
            maxBloomDays = Math.max(maxBloomDays, currPlantBloomTime);
        }
        return maxBloomDays;
    }
}
