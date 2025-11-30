public class insert {
	public static double insert1(double[][] data, int Row, int Col) {
        double top = 0;
        double below = 0;
        
        // Iterate through all known points
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {
                if (!Double.isNaN(data[i][j])) 
                {
                    // distance count
                    double distance = Math.sqrt(Math.pow(Row - i, 2) + Math.pow(Col - j, 2));
                    
                    // weight count
                    double weight = 1.0 / (distance * distance);
                    
                    // add up
                    top += weight * data[i][j];
                    below += weight;
                }
            }
        }
        double rst = top / below;
        // 返回结果（手动输入）
        return rst;
    }
}