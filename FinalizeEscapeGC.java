package JVMtest;

public class FinalizeEscapeGC {
	
	public static FinalizeEscapeGC Save=null;
	public void isAlive() {
		System.out.println(" i alive");
	}
		@Override
		protected void finalize() throws Throwable {
			// TODO Auto-generated method stub
			super.finalize();
			System.out.println("fin executed");
			FinalizeEscapeGC.Save=this;
		}
	public static void main(String[] args) throws Throwable {
		// 任何对象的finalize方法只会执行一次
		Save=new FinalizeEscapeGC();
		Save=null;
		System.gc();
		Thread.sleep(500);
		if (Save!=null) {
			Save.isAlive();
		}
		else {
			System.out.println(" dead");
		}
		Save=null;
		System.gc();
		Thread.sleep(500);
		if (Save!=null) {
			Save.isAlive();
		}
		else {
			System.out.println(" dead");
		}
	}

}
