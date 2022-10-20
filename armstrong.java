public class arm{
	static int kol(int a) {
		int k = 0;
		while(a > 0) {
			k += 1;
			a /= 10;
		}
		return k;
	}
	
	static int st(int osn, int pok) {
		int res = osn;
		for(int i = 1; i < pok; i += 1) {
			res *= osn;
		}
		return res;
	}
	
	static void arm(int n) {
		int sum = 0;
		int p = n;
		int k = kol(n);
		while(p > 0) {
			sum += st(p % 10, k);
			p /= 10;
		}
		if (sum == n){
			System.out.print("YES");
		} else {
			System.out.print("NO");
		}
	}
	
	public static void main(String args[]) {
		int n = 153;
		arm(n);
	}
}


