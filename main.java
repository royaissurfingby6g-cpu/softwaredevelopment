public class main 
{
	public static void main(String[] args) //test data
	{
        //static type
		double[][] test = 
        {
            {1.0, Double.NaN, 3.0},
            {Double.NaN, Double.NaN, 2.0},
            {4.0, 5.0, Double.NaN}
        };
        
        // calls of idw function 
        double[][] result = idw.idw1(test);
        
        // print
        for (int i = 0; i < result.length; i++) {          // 一行一行来
            for (int j = 0; j < result[i].length; j++) {   // 一行里的每个数
                System.out.println(result[i][j]+ " ");      // 打印数字+空格
            }
            System.out.println();                          // 打完一行就换行
        }

	}
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
	public class idw {
		//create idw function 
		public static double[][] idw1(double[][] data) 
		{
	        // create new arr
	        double[][] result = new double[data.length][data[0].length];
	        for (int i = 0; i < data.length; i++)
	        {
	            for (int j = 0; j < data[0].length; j++) 
	            {
	                if (Double.isNaN(data[i][j])) 
	                {
	                    result[i][j] = insert.insert1(data, i, j);
	                } 
	                else
	                {
	                    result[i][j] = data[i][j];
	                }
	            }
	        }
	        return result;
	    }

	}

}
