public class LoadingScreen {

    public LoadingScreen() {
    }

    public static void loadingScreen() throws InterruptedException {
        int total = 50;
        for(int i = 0; i <= total; i++) {
            int percent = (i*100) / total;

            StringBuilder bar = new StringBuilder ("[");
            for(int j = 0; j < total; j++) {
                if(j < i) {
                    bar.append("#");
                } else {
                    bar.append(" ");
                }
            }
            bar.append("] ").append(percent).append("%");

            System.out.print("\r" + bar);
            System.out.flush();

            Thread.sleep(50);
        }
        System.out.println("\nLoading Complete!");
    }
}
