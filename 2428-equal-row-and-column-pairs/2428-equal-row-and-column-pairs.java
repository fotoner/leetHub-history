class Solution {
    public int equalPairs(int[][] grid) {
        HashMap<String, Integer> rowMap = new HashMap<>();
        HashMap<String, Integer> columnMap = new HashMap<>();

        int sum = 0;

        for (int i = 0; i < grid.length; i++) {
            String rowString = Arrays.toString(grid[i]);

            StringBuilder builder = new StringBuilder();
            builder.append('[');
            for (int j = 0; j < grid.length; j++) {
                builder.append(grid[j][i]);
                if (j < grid.length - 1) builder.append(", ");
            }
            builder.append(']');
            String columnString = builder.toString();

            rowMap.put(rowString, rowMap.getOrDefault(rowString, 0) + 1);
            columnMap.put(columnString, columnMap.getOrDefault(columnString, 0) + 1);
        }
        for (String key: rowMap.keySet()){
            int rowCount = rowMap.getOrDefault(key, 0);
            int columnCount = columnMap.getOrDefault(key, 0);

            sum += rowCount * columnCount;
        }
        
        return sum;
    }
}