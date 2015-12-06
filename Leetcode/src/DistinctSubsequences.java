
public class DistinctSubsequences {
	public int numDistinct(String s, String t) {
        if(s==null||t==null)return 0;
        if(s.length()<t.length())return 0;
        int [][] dist = new int[s.length()+1][t.length()+1];
        for(int i=0;i<=s.length();i++){
        	dist[i][0] = 1;
        }
        for(int i=1;i<=s.length();i++){
        	for(int j=1;j<=t.length();j++){
        		dist[i][j] = dist[i-1][j];
        		if(s.charAt(i-1)==t.charAt(j-1)){
        			dist[i][j]+=dist[i-1][j-1];
        		}
        	}
        }
        return dist[s.length()][t.length()];
    }
	public static void main(String[] args) {
		String s = "rabbbit";
		String t = "rabbit";
		System.out.println(new DistinctSubsequences().numDistinct(s, t));
	}

}
