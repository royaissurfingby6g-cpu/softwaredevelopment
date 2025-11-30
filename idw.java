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
