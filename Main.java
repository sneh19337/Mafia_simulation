package jdbc;
        import java.util.*;

interface common_things
{
        int getHP();
}
class Player
{
        Scanner sc=new Scanner(System.in);
        int id;
        String type;
        int HP;
        int vote;
        Player()
        {
                id=0;
                type="none";
                HP=0;
                vote=0;
        }
        public Player(int u, String s,int HP,int vote) {
                this.id=u;
                this.type=s;
                this.HP=HP;
                this.vote=vote;
        }

        protected int getid() {
                return id;
        }

        protected String gettype() {
                return type;
        }
        protected int getHP()
        {
                return HP;
        }
        protected int setHP(int HP,int damage)
        {
                if(this.HP>=0)
                {this.HP = HP - damage;}
                return this.HP;

        }
        protected int getvote()
        {
                return vote;
        }
        protected int setvote()
        {
                this.vote=this.vote+1;
                return this.vote;
        }
}
class Mafia extends Player implements common_things {

        @Override
        public int getHP()
        {
                return HP;
        }
        public int setHP(int HP,int damage)
        {
                if(this.HP>=0)
                {this.HP = HP - damage;}
                return this.HP;

        }


}
class Detective extends Player implements common_things
{
        @Override
        public int getHP()
        {
                return HP;
        }
        public int setHP(int HP,int damage)
        {
                if(this.HP>=0)
                {this.HP = HP - damage;}
                return this.HP;

        }

}
class Healer extends Player implements common_things
{

        @Override
        public int getHP()
        {
                return HP;
        }
        public int setHP(int HP,int damage)
        {
                if(this.HP>=0)
                {this.HP = HP - damage;}
                return this.HP;

        }
}
class Commoner extends Player implements common_things
{

        @Override
        public int getHP()
        {
                return HP;
        }
        public int setHP(int HP,int damage)
        {
                if(this.HP>=0)
                {this.HP = HP - damage;}
                return this.HP;

        }
}
abstract public class Main extends Player {

        public static void main(String[] args) {
                // write your code here
                Scanner sc = new Scanner(System.in);
                Mafia mf = new Mafia();

                System.out.println("\033[32mPlease enter the number of players for the game\n");
                int n = sc.nextInt();
                while (n < 6) {
                        System.out.println("\033[31mSorry there are insufficient players\n");
                        System.out.println("\033[34mPlease enter the players again");
                        n = sc.nextInt();


                }
                if (n == 6) {
                        System.out.println("\033[30mYou are good to go");
                }
                if (n > 6) {
                        System.out.println("\033[30mYou are good to go");

                }

                //Generic array
                Player[] a = new Player[n];
                List<List> lis = new ArrayList<List>();
                ArrayList<Player> list = new ArrayList<>();
                ArrayList<Player>record=new ArrayList<>();
                ArrayList<String> li = new ArrayList<>();
                int number = 0;

                lis.add(li);
                lis.add(list);
                int u = n - ((n) / 5) - n / 5;
                // System.out.println(u);
                u = u - ((n) / 10);
                for (int i = 0; i < n; ) {
                        for (int j = 0; j < n / 5; j++) {
                                a[i] = new Player(j + 1, "mafia", 2500,0);
                                i++;
                        }
                        int y = n / 5 + 1;
                        for (int j = 0; j < n / 5; j++) {

                                a[i] = new Player(y, "detective", 800,0);
                                y++;
                                i++;
                        }
                        //y++;
                        for (int j = 0; j < n / 10; j++) {
                                a[i] = new Player(y, "healer", 800,0);
                                y++;
                                i++;
                        }
                        // y++;
                        for (int j = 0; j < u; j++) {
                                a[i] = new Player(y, "commoner", 1000,0);
                                y++;
                                i++;
                        }
                }
                Collections.shuffle(Arrays.asList(a));
                Healer hf=new Healer();
                Detective dm=new Detective();
                Commoner cm=new Commoner();

//list is used to create randomness
                for (int i = 0; i < n; ) {
                        for (int j = 1; j < n + 1; j++) {
                                list.add(a[i]);
                                record.add(a[i]);
                                i++;
                        }
                }
                //The game begins here
                System.out.println("\033[34mHey welcome to the player selection process");
                System.out.println("\033[32m Please select the players ");
                System.out.println("1->Mafia  ");
                System.out.println("2->Detective ");
                System.out.println("3->Healer");
                System.out.println("4->Commaner");
                System.out.println("5->Computer ");
                int f = sc.nextInt();
                //////////////////////////////////Player Making / Picking///////////////////////////////////////////////////////////////
                if (f == 1) {                 //while you are a mafia
                        System.out.println("Mafia is selected ");
                        System.out.println("You are a mafia for the game");
                        for (int i = 0; i < list.size(); i++) {

                                if (list.get(i).gettype().equals("mafia")) {
                                        number = number + 1;
                                        System.out.println("You are player " + (i + 1) );
                                        //System.out.println("The HP of the mafia is initially" + mf.getHP());

                                        i++;

                                        while (i < list.size()) {
                                                if (list.get(i).gettype().equals("mafia")) {
                                                        number = number + 1;
                                                        System.out.println("Other mafia  players in the game are " + "Player " + (i + 1) );
                                                }
                                                i++;
                                        }
                                }
                        }

                        //Round begins
                        int mafias=0;
                        int others=0;
                        int size=list.size();
                        int sized=list.size();
                        int round=0;
                        while(size>0) {
                                int[] votes = new int[n];
                                System.out.println("ROUND " + (round) + " BEGINS");


                                //mafia chooses a target
                                System.out.println("Mafia chooses a target");
                                int sum = 0;
                                for (int i = 0; i < list.size(); i++) {
                                        if (list.get(i).gettype().equals("mafia")) {
                                                sum = sum + list.get(i).getHP();
                                        }
                                }
                                Random rand = new Random();
                                int c = sc.nextInt();
                                // System.out.println("mafia " + c);
                                for (int i = 0; i < list.size(); i++) {
                                        if (c == list.get(i).getid()) {
                                                String s = list.get(i).gettype();
                                                if (Objects.equals(s, "detective")) {
                                                        if (list.get(i).getHP() < sum) {
                                                                int vgy = list.get(i).getHP();

                                                                list.get(i).setHP(list.get(i).getHP(), list.get(i).getHP());

                                                        }
                                                }
                                                if (Objects.equals(s, "healer")) {
                                                        if (list.get(i).getHP() < sum)
                                                                list.get(i).setHP(list.get(i).getHP(), list.get(i).getHP());
                                                }
                                                if (Objects.equals(s, "commoner")) {
                                                        if (list.get(i).getHP() < sum)
                                                                list.get(i).setHP(list.get(i).getHP(), list.get(i).getHP());
                                                }
                                        }
                                }
                                System.out.println("Detective is testing someone ");
                                System.out.println("Healer is selecting someone to heal");
                                Random random = new Random();
                                int cc = random.ints(1, n + 1).findFirst().getAsInt();
                                //System.out.println("mafia " + cc);
                                for (int i = 0; i < list.size(); i++) {
                                        if (cc == list.get(i).getid()) {
                                                String sf = list.get(i).gettype();
                                                if (Objects.equals(sf, "mafia"))
                                                {
                                                        list.remove(list.get(i));
                                                        size--;

                                                        //healer is selecting someone
                                                        Random randomize = new Random();
                                                        int ccc = randomize.ints(1, n + 1).findFirst().getAsInt();
                                                        // System.out.println("mafia " + ccc);
                                                        for (int y = 0; y < list.size(); y++) {
                                                                if (ccc == list.get(y).getid()) {

                                                                        list.get(y).setHP(list.get(y).getHP(), -500);

                                                                }
                                                        }
                                                }

                                                if(!Objects.equals(sf, "mafia")) {
                                                        //voting
                                                        // System.out.println("Healer is selecting someone to heal");
                                                        Random randomize = new Random();
                                                        int ccc = randomize.ints(1, n + 1).findFirst().getAsInt();
                                                        //System.out.println("mafia " + ccc);
                                                        for (int y = 0; y < list.size(); y++) {
                                                                if (ccc == list.get(y).getid()) {

                                                                        list.get(y).setHP(list.get(y).getHP(), -500);

                                                                }
                                                        }

                                                        int max = Integer.MIN_VALUE;
                                                        for (int vo = 0; vo < list.size(); vo++) {

                                                                while (sized >= 0) {
                                                                        Random randomized = new Random();
                                                                        int co = randomized.ints(1, n + 1).findFirst().getAsInt();
                                                                        for (int y = 0; y < list.size(); y++) {
                                                                                if (co == list.get(y).getid()) {
                                                                                        list.get(y).setvote();
                                                                                }
                                                                        }
                                                                        sized--;
                                                                }


                                                                for (int ie = 0; ie < list.size(); ie++) {
                                                                        votes[ie] = list.get(ie).getvote();
                                                                }
                                                                for (int ig = 0; ig < list.size(); ig++) {
                                                                        if (max < votes[ig]) {
                                                                                max = votes[ig];
                                                                        }

                                                                }
                                                        }



                                                        //voted out
                                                        for (int di = 0; di < list.size(); di++) {
                                                                if (max == list.get(di).getvote()) {
                                                                        System.out.println("The player voted out is" + (di + 1));
                                                                        list.remove(list.get(di));

                                                                        break;
                                                                }
                                                        }
                                                        size--;

                                                        //HP out
                                                        for ( int fi = 0; fi < list.size(); fi++) {
                                                                if (0 == list.get(fi).getHP()) {
                                                                        System.out.println("The player died is" + (fi + 1));
                                                                        list.remove(list.get(fi));
                                                                        // break;
                                                                }
                                                        }
                                                        size--;
                                                }
                                        }

                                }
                                //counting process
                                for (int i = 0; i < list.size(); i++) {
                                        if (list.get(i).gettype().equals("mafia")) {
                                                mafias = mafias + 1;
                                        } else {
                                                others = others + 1;
                                        }
                                }
                                if (mafias == others||others==0||round>60) {
                                        System.out.println("\033[31mGame over -");
                                        System.out.println("\033[31mMafias won");
                                        break;
                                }

                                round++;
                        }
                        if((mafias!=others)&&round<60)
                        {
                                System.out.println("\033[31mGame Over -");
                                System.out.println("\033[31mMafias lost");

                        }

                }


                if (f == 2) {                 //while you are a detective
                        System.out.println("Detective is selected ");
                        System.out.println("You are a detective for the game");
                        for (int i = 0; i < list.size(); i++) {

                                if (list.get(i).gettype().equals("detective")) {

                                        System.out.println("You are player " + (i + 1) );
                                        i++;

                                        while (i < list.size()) {
                                                if (list.get(i).gettype().equals("detective")) {
                                                        System.out.println("Other detective  players in the game are " + "Player " + (i + 1) );

                                                }
                                                i++;
                                        }
                                }
                        }
                        //Round begins
                        int mafias=0;
                        int others=0;
                        int size=list.size();
                        int sized=list.size();
                        int round=0;
                        while(size>0) {
                                int[] votes = new int[n];
                                System.out.println("ROUND " + (round) + " BEGINS");


                                //mafia chooses a target
                                System.out.println("Mafia chooses a target");
                                int sum = 0;
                                for (int i = 0; i < list.size(); i++) {
                                        if (list.get(i).gettype().equals("mafia")) {
                                                sum = sum + list.get(i).getHP();
                                        }
                                }
                                Random rand = new Random();
                                int c = rand.ints(1, n + 1).findFirst().getAsInt();
                                // System.out.println("mafia " + c);
                                for (int i = 0; i < list.size(); i++) {
                                        if (c == list.get(i).getid()) {
                                                String s = list.get(i).gettype();
                                                if (Objects.equals(s, "mafia")) {
                                                        if (list.get(i).getHP() < sum) {
                                                                int vgy = list.get(i).getHP();

                                                                list.get(i).setHP(list.get(i).getHP(), list.get(i).getHP());

                                                        }
                                                }
                                                if (Objects.equals(s, "healer")) {
                                                        if (list.get(i).getHP() < sum)
                                                                list.get(i).setHP(list.get(i).getHP(), list.get(i).getHP());
                                                }
                                                if (Objects.equals(s, "commoner")) {
                                                        if (list.get(i).getHP() < sum)
                                                                list.get(i).setHP(list.get(i).getHP(), list.get(i).getHP());
                                                }
                                        }
                                }
                                System.out.println("Detective is testing someone ");
                                System.out.println("Please choose someone to test");
                                Random random = new Random();
                                int cc = sc.nextInt();
                                System.out.println("Healer is selecting someone to heal");
                                //System.out.println("mafia " + cc);
                                for (int i = 0; i < list.size(); i++) {
                                        if (cc == list.get(i).getid()) {
                                                String sf = list.get(i).gettype();
                                                if (Objects.equals(sf, "mafia"))
                                                {
                                                        list.remove(list.get(i));
                                                        size--;

                                                        //healer is selecting someone
                                                        Random randomize = new Random();
                                                        int ccc = randomize.ints(1, n + 1).findFirst().getAsInt();
                                                        //System.out.println("mafia " + ccc);
                                                        for (int y = 0; y < list.size(); y++) {
                                                                if (ccc == list.get(y).getid()) {

                                                                        list.get(y).setHP(list.get(y).getHP(), -500);

                                                                }
                                                        }
                                                }

                                                if(!Objects.equals(sf, "mafia")) {
                                                        //voting
                                                        // System.out.println("Healer is selecting someone to heal");
                                                        Random randomize = new Random();
                                                        int ccc = randomize.ints(1, n + 1).findFirst().getAsInt();
                                                        // System.out.println("mafia " + ccc);
                                                        for (int y = 0; y < list.size(); y++) {
                                                                if (ccc == list.get(y).getid()) {

                                                                        list.get(y).setHP(list.get(y).getHP(), -500);

                                                                }
                                                        }

                                                        int max = Integer.MIN_VALUE;
                                                        for (int vo = 0; vo < list.size(); vo++) {

                                                                while (sized >= 0) {
                                                                        Random randomized = new Random();
                                                                        int co = randomized.ints(1, n + 1).findFirst().getAsInt();
                                                                        for (int y = 0; y < list.size(); y++) {
                                                                                if (co == list.get(y).getid()) {
                                                                                        list.get(y).setvote();
                                                                                }
                                                                        }
                                                                        sized--;
                                                                }


                                                                for (int ie = 0; ie < list.size(); ie++) {
                                                                        votes[ie] = list.get(ie).getvote();
                                                                }
                                                                for (int ig = 0; ig < list.size(); ig++) {
                                                                        if (max < votes[ig]) {
                                                                                max = votes[ig];
                                                                        }

                                                                }
                                                        }



                                                        //voted out
                                                        for (int di = 0; di < list.size(); di++) {
                                                                if (max == list.get(di).getvote()) {
                                                                        System.out.println("The player voted out is" + (di + 1));
                                                                        list.remove(list.get(di));

                                                                        break;
                                                                }
                                                        }
                                                        size--;

                                                        //HP out
                                                        for ( int fi = 0; fi < list.size(); fi++) {
                                                                if (0 == list.get(fi).getHP()) {
                                                                        System.out.println("The player died is" + (fi + 1));
                                                                        list.remove(list.get(fi));
                                                                        // break;
                                                                }
                                                        }
                                                        size--;
                                                }
                                        }

                                }
                                //counting process
                                for (int i = 0; i < list.size(); i++) {
                                        if (list.get(i).gettype().equals("mafia")) {
                                                mafias = mafias + 1;
                                        } else {
                                                others = others + 1;
                                        }
                                }
                                if (mafias == others||others==0||round>60) {
                                        System.out.println("\033[31mGame over -");
                                        System.out.println("\033[31mMafias won");
                                        break;
                                }

                                round++;
                        }
                        if((mafias!=others)&&round<60)
                        {
                                System.out.println("\033[31mGame Over -");
                                System.out.println("\033[31mMafias lost");

                        } }
                //System.out.println(list.size());

                if (f == 3)
                {                 //while you are a healer
                        System.out.println("Healer is selected ");
                        System.out.println("You are a healer for the game");
                        for (int i = 0; i < list.size(); i++) {

                                if (list.get(i).gettype().equals("healer")) {

                                        System.out.println("You are player " + (i + 1) );

                                        i++;

                                        while (i < list.size()) {
                                                if (list.get(i).gettype().equals("healer")) {
                                                        System.out.println("Other healer  players in the game are " + "Player " + (i + 1) );

                                                }
                                                i++;
                                        }
                                }
                        }
                        //Round begins
                        int mafias=0;
                        int others=0;
                        int size=list.size();
                        int sized=list.size();
                        int round=0;
                        while(size>0) {
                                int[] votes = new int[n];
                                System.out.println("ROUND " + (round) + " BEGINS");


                                //mafia chooses a target
                                System.out.println("Mafia chooses a target");
                                int sum = 0;
                                for (int i = 0; i < list.size(); i++) {
                                        if (list.get(i).gettype().equals("mafia")) {
                                                sum = sum + list.get(i).getHP();
                                        }
                                }
                                Random rand = new Random();
                                int c = rand.ints(1, n + 1).findFirst().getAsInt();
                                //System.out.println("mafia " + c);
                                for (int i = 0; i < list.size(); i++) {
                                        if (c == list.get(i).getid()) {
                                                String s = list.get(i).gettype();
                                                if (Objects.equals(s, "detective")) {
                                                        if (list.get(i).getHP() < sum) {
                                                                int vgy = list.get(i).getHP();

                                                                list.get(i).setHP(list.get(i).getHP(), list.get(i).getHP());

                                                        }
                                                }
                                                if (Objects.equals(s, "mafia")) {
                                                        if (list.get(i).getHP() < sum)
                                                                list.get(i).setHP(list.get(i).getHP(), list.get(i).getHP());
                                                }
                                                if (Objects.equals(s, "commoner")) {
                                                        if (list.get(i).getHP() < sum)
                                                                list.get(i).setHP(list.get(i).getHP(), list.get(i).getHP());
                                                }
                                        }
                                }
                                System.out.println("Detective is testing someone ");
                                System.out.println("Healer is selecting someone to heal");
                                Random random = new Random();
                                int cc = random.ints(1, n + 1).findFirst().getAsInt();
                                //System.out.println("mafia " + cc);
                                for (int i = 0; i < list.size(); i++) {
                                        if (cc == list.get(i).getid()) {
                                                String sf = list.get(i).gettype();
                                                if (Objects.equals(sf, "mafia"))
                                                {
                                                        list.remove(list.get(i));
                                                        size--;

                                                        //healer is selecting someone
                                                        Random randomize = new Random();
                                                        System.out.println("Please choose someone to heal");
                                                        int ccc = sc.nextInt();
                                                        // System.out.println("mafia " + ccc);
                                                        for (int y = 0; y < list.size(); y++) {
                                                                if (ccc == list.get(y).getid()) {

                                                                        list.get(y).setHP(list.get(y).getHP(), -500);

                                                                }
                                                        }
                                                }

                                                if(!Objects.equals(sf, "mafia")) {
                                                        //voting
                                                        // System.out.println("Healer is selecting someone to heal");
                                                        Random randomize = new Random();
                                                        System.out.println("Please choose someone to heal");
                                                        int ccc = sc.nextInt();
                                                        // System.out.println("mafia " + ccc);
                                                        for (int y = 0; y < list.size(); y++) {
                                                                if (ccc == list.get(y).getid()) {

                                                                        list.get(y).setHP(list.get(y).getHP(), -500);

                                                                }
                                                        }

                                                        int max = Integer.MIN_VALUE;
                                                        for (int vo = 0; vo < list.size(); vo++) {

                                                                while (sized >= 0) {
                                                                        Random randomized = new Random();
                                                                        int co = randomized.ints(1, n + 1).findFirst().getAsInt();
                                                                        for (int y = 0; y < list.size(); y++) {
                                                                                if (co == list.get(y).getid()) {
                                                                                        list.get(y).setvote();
                                                                                }
                                                                        }
                                                                        sized--;
                                                                }


                                                                for (int ie = 0; ie < list.size(); ie++) {
                                                                        votes[ie] = list.get(ie).getvote();
                                                                }
                                                                for (int ig = 0; ig < list.size(); ig++) {
                                                                        if (max < votes[ig]) {
                                                                                max = votes[ig];
                                                                        }

                                                                }
                                                        }



                                                        //voted out
                                                        for (int di = 0; di < list.size(); di++) {
                                                                if (max == list.get(di).getvote()) {
                                                                        System.out.println("The player voted out is" + (di + 1));
                                                                        list.remove(list.get(di));

                                                                        break;
                                                                }
                                                        }
                                                        size--;

                                                        //HP out
                                                        for ( int fi = 0; fi < list.size(); fi++) {
                                                                if (0 == list.get(fi).getHP()) {
                                                                        System.out.println("The player died is" + (fi + 1));
                                                                        list.remove(list.get(fi));
                                                                        // break;
                                                                }
                                                        }
                                                        size--;
                                                }
                                        }

                                }
                                //counting process
                                for (int i = 0; i < list.size(); i++) {
                                        if (list.get(i).gettype().equals("mafia")) {
                                                mafias = mafias + 1;
                                        } else {
                                                others = others + 1;
                                        }
                                }
                                if (mafias == others||others==0||round>60) {
                                        System.out.println("\033[31mGame over -");
                                        System.out.println("\033[31mMafias won");
                                        break;
                                }

                                round++;
                        }
                        if((mafias!=others)&&round<60)
                        {
                                System.out.println("\033[31mGame Over -");
                                System.out.println("\033[31mMafias lost");

                        } }


                if (f == 4) {                 //while you are a commoner
                        System.out.println("Commoner is selected ");
                        System.out.println("You are a commoner for the game");
                        for (int i = 0; i < list.size(); i++) {

                                if (list.get(i).gettype().equals("commoner")) {

                                        System.out.println("You are player " + (i + 1) );
                                        break;

//                        while (i < list.size()) {
//                            if (list.get(i).gettype().equals("commoner")) {
//                                System.out.println("Other commoner  players in the game are " + "Player " + (i + 1) + " with id" + list.get(i).getid());
//
//                            }
//                            i++;
//                        }
                                }
                        }
                        //Round begins
                        int mafias=0;
                        int others=0;
                        int size=list.size();
                        int sized=list.size();
                        int round=0;
                        while(size>0) {
                                int[] votes = new int[n];
                                System.out.println("ROUND " + (round) + " BEGINS");


                                //mafia chooses a target
                                System.out.println("Mafia chooses a target");
                                int sum = 0;
                                for (int i = 0; i < list.size(); i++) {
                                        if (list.get(i).gettype().equals("mafia")) {
                                                sum = sum + list.get(i).getHP();
                                        }
                                }
                                Random rand = new Random();
                                int c = rand.ints(1, n + 1).findFirst().getAsInt();
                                // System.out.println("mafia " + c);
                                for (int i = 0; i < list.size(); i++) {
                                        if (c == list.get(i).getid()) {
                                                String s = list.get(i).gettype();
                                                if (Objects.equals(s, "detective")) {
                                                        if (list.get(i).getHP() < sum) {
                                                                int vgy = list.get(i).getHP();

                                                                list.get(i).setHP(list.get(i).getHP(), list.get(i).getHP());

                                                        }
                                                }
                                                if (Objects.equals(s, "mafia")) {
                                                        if (list.get(i).getHP() < sum)
                                                                list.get(i).setHP(list.get(i).getHP(), list.get(i).getHP());
                                                }
                                                if (Objects.equals(s, "healer")) {
                                                        if (list.get(i).getHP() < sum)
                                                                list.get(i).setHP(list.get(i).getHP(), list.get(i).getHP());
                                                }
                                        }
                                }
                                System.out.println("Detective is testing someone ");
                                System.out.println("Healer is selecting someone to heal");
                                Random random = new Random();
                                int cc = random.ints(1, n + 1).findFirst().getAsInt();
                                //System.out.println("mafia " + cc);
                                for (int i = 0; i < list.size(); i++) {
                                        if (cc == list.get(i).getid()) {
                                                String sf = list.get(i).gettype();
                                                if (Objects.equals(sf, "mafia"))
                                                {
                                                        list.remove(list.get(i));
                                                        size--;

                                                        //healer is selecting someone
                                                        Random randomize = new Random();
                                                        int ccc = randomize.ints(1, n + 1).findFirst().getAsInt();
                                                        // System.out.println("mafia " + ccc);
                                                        for (int y = 0; y < list.size(); y++) {
                                                                if (ccc == list.get(y).getid()) {

                                                                        list.get(y).setHP(list.get(y).getHP(), -500);

                                                                }
                                                        }
                                                }

                                                if(!Objects.equals(sf, "mafia")) {
                                                        //voting
                                                        // System.out.println("Healer is selecting someone to heal");
                                                        Random randomize = new Random();
                                                        int ccc = randomize.ints(1, n + 1).findFirst().getAsInt();
                                                        //  System.out.println("mafia " + ccc);
                                                        for (int y = 0; y < list.size(); y++) {
                                                                if (ccc == list.get(y).getid()) {

                                                                        list.get(y).setHP(list.get(y).getHP(), -500);

                                                                }
                                                        }

                                                        int max = Integer.MIN_VALUE;
                                                        System.out.println("Please vote your choice");
                                                        int ye=sc.nextInt();
                                                        for(int ed=0;ed<1;ed++) {
                                                                if (ye == list.get(ed).getid()) {
                                                                        list.get(ed).setvote();
                                                                        // break;
                                                                }
                                                        }
                                                        for (int vo = 0; vo < list.size(); vo++) {


                                                                while (sized >= 0) {
                                                                        Random randomized = new Random();
                                                                        int co = randomized.ints(1, n + 1).findFirst().getAsInt();

                                                                        for (int y = 0; y < list.size()-1; y++) {
                                                                                if (co == list.get(y).getid()) {
                                                                                        list.get(y).setvote();
                                                                                }
                                                                        }
                                                                        sized--;
                                                                }


                                                                for (int ie = 0; ie < list.size(); ie++) {
                                                                        votes[ie] = list.get(ie).getvote();
                                                                }
                                                                for (int ig = 0; ig < list.size(); ig++) {
                                                                        if (max < votes[ig]) {
                                                                                max = votes[ig];
                                                                        }

                                                                }
                                                        }



                                                        //voted out
                                                        for (int di = 0; di < list.size(); di++) {
                                                                if (max == list.get(di).getvote()) {
                                                                        System.out.println("The player voted out is" + (di + 1));
                                                                        list.remove(list.get(di));

                                                                        break;
                                                                }
                                                        }
                                                        size--;

                                                        //HP out
                                                        for ( int fi = 0; fi < list.size(); fi++) {
                                                                if (0 == list.get(fi).getHP()) {
                                                                        System.out.println("The player died is" + (fi + 1));
                                                                        list.remove(list.get(fi));
                                                                        // break;
                                                                }
                                                        }
                                                        size--;
                                                }
                                        }

                                }
                                //counting process
                                for (int i = 0; i < list.size(); i++) {
                                        if (list.get(i).gettype().equals("mafia")) {
                                                mafias = mafias + 1;
                                        } else {
                                                others = others + 1;
                                        }
                                }
                                if (mafias == others||others==0||round>60) {
                                        System.out.println("\033[31mGame over -");
                                        System.out.println("\033[31mMafias won");
                                        break;
                                }

                                round++;
                        }
                        if((mafias!=others)&&round<60)
                        {
                                System.out.println("\033[31mGame Over -");
                                System.out.println("\033[31mMafias lost");

                        } }
                // System.out.println(list.size());

                //for testing purpose
                // for (int i = 0; i < record.size(); i++) {

                //   System.out.print("\033[30mPlayer" + (i + 1) + "  " + "was a  " + record.get(i).gettype()+" , ");
                //}

                if (f == 5) {                 //while you are a random player
                        System.out.println("Automated selection is selected ");
                        System.out.println(" Congrats you are given ");
                        Random random = new Random();
                        int cho = 0;
                        int c = random.ints(1, n + 1).findFirst().getAsInt();
                        for (int i = 0; i < list.size(); i++) {

                                if (c == list.get(i).getid()) {
                                        String s = list.get(i).gettype();
                                        cho = i + 1;
                                        System.out.println("You are player " + (i + 1) + "with type " + list.get(i).gettype());
                                        //i++;
                                        i = 0;
                                        while (i < list.size()) {

                                                if (!s.equals("commoner") && list.get(i).gettype().equals(s) && c != list.get(i).getid()) {
                                                        System.out.println("Other " + list.get(i).gettype() + " players in the game are " + "Player " + (i + 1));

                                                }
                                                i++;
                                        }

                                }
                        }
                        if (Objects.equals(list.get(cho).gettype(), "mafia")) {
                                //Round begins
                                int mafias = 0;
                                int others = 0;
                                int size = list.size();
                                int sized = list.size();
                                int round = 0;
                                while (size > 0) {
                                        int[] votes = new int[n];
                                        System.out.println("ROUND " + (round) + " BEGINS");


                                        //mafia chooses a target
                                        System.out.println("Mafia chooses a target");
                                        int sum = 0;
                                        for (int i = 0; i < list.size(); i++) {
                                                if (list.get(i).gettype().equals("mafia")) {
                                                        sum = sum + list.get(i).getHP();
                                                }
                                        }
                                        Random rand = new Random();
                                        int cot = sc.nextInt();
                                        // System.out.println("mafia " + c);
                                        for (int i = 0; i < list.size(); i++) {
                                                if (cot == list.get(i).getid()) {
                                                        String s = list.get(i).gettype();
                                                        if (Objects.equals(s, "detective")) {
                                                                if (list.get(i).getHP() < sum) {
                                                                        int vgy = list.get(i).getHP();

                                                                        list.get(i).setHP(list.get(i).getHP(), list.get(i).getHP());

                                                                }
                                                        }
                                                        if (Objects.equals(s, "healer")) {
                                                                if (list.get(i).getHP() < sum)
                                                                        list.get(i).setHP(list.get(i).getHP(), list.get(i).getHP());
                                                        }
                                                        if (Objects.equals(s, "commoner")) {
                                                                if (list.get(i).getHP() < sum)
                                                                        list.get(i).setHP(list.get(i).getHP(), list.get(i).getHP());
                                                        }
                                                }
                                        }
                                        System.out.println("Detective is testing someone ");
                                        System.out.println("Healer is selecting someone to heal");
                                        //Random random = new Random();
                                        int cc = random.ints(1, n + 1).findFirst().getAsInt();
                                        //System.out.println("mafia " + cc);
                                        for (int i = 0; i < list.size(); i++) {
                                                if (cc == list.get(i).getid()) {
                                                        String sf = list.get(i).gettype();
                                                        if (Objects.equals(sf, "mafia")) {
                                                                list.remove(list.get(i));
                                                                size--;

                                                                //healer is selecting someone
                                                                Random randomize = new Random();
                                                                int ccc = randomize.ints(1, n + 1).findFirst().getAsInt();
                                                                // System.out.println("mafia " + ccc);
                                                                for (int y = 0; y < list.size(); y++) {
                                                                        if (ccc == list.get(y).getid()) {

                                                                                list.get(y).setHP(list.get(y).getHP(), -500);

                                                                        }
                                                                }
                                                        }

                                                        if (!Objects.equals(sf, "mafia")) {
                                                                //voting
                                                                // System.out.println("Healer is selecting someone to heal");
                                                                Random randomize = new Random();
                                                                int ccc = randomize.ints(1, n + 1).findFirst().getAsInt();
                                                                //System.out.println("mafia " + ccc);
                                                                for (int y = 0; y < list.size(); y++) {
                                                                        if (ccc == list.get(y).getid()) {

                                                                                list.get(y).setHP(list.get(y).getHP(), -500);

                                                                        }
                                                                }

                                                                int max = Integer.MIN_VALUE;
                                                                for (int vo = 0; vo < list.size(); vo++) {

                                                                        while (sized >= 0) {
                                                                                Random randomized = new Random();
                                                                                int co = randomized.ints(1, n + 1).findFirst().getAsInt();
                                                                                for (int y = 0; y < list.size(); y++) {
                                                                                        if (co == list.get(y).getid()) {
                                                                                                list.get(y).setvote();
                                                                                        }
                                                                                }
                                                                                sized--;
                                                                        }


                                                                        for (int ie = 0; ie < list.size(); ie++) {
                                                                                votes[ie] = list.get(ie).getvote();
                                                                        }
                                                                        for (int ig = 0; ig < list.size(); ig++) {
                                                                                if (max < votes[ig]) {
                                                                                        max = votes[ig];
                                                                                }

                                                                        }
                                                                }


                                                                //voted out
                                                                for (int di = 0; di < list.size(); di++) {
                                                                        if (max == list.get(di).getvote()) {
                                                                                System.out.println("The player voted out is" + (di + 1));
                                                                                list.remove(list.get(di));

                                                                                break;
                                                                        }
                                                                }
                                                                size--;

                                                                //HP out
                                                                for (int fi = 0; fi < list.size(); fi++) {
                                                                        if (0 == list.get(fi).getHP()) {
                                                                                System.out.println("The player died is" + (fi + 1));
                                                                                list.remove(list.get(fi));
                                                                                // break;
                                                                        }
                                                                }
                                                                size--;
                                                        }
                                                }

                                        }
                                        //counting process
                                        for (int i = 0; i < list.size(); i++) {
                                                if (list.get(i).gettype().equals("mafia")) {
                                                        mafias = mafias + 1;
                                                } else {
                                                        others = others + 1;
                                                }
                                        }
                                        if (mafias == others || others == 0 || round > 60) {
                                                System.out.println("\033[31mGame over -");
                                                System.out.println("\033[31mMafias won");
                                                break;
                                        }

                                        round++;
                                }
                                if ((mafias != others) && round < 60) {
                                        System.out.println("\033[31mGame Over -");
                                        System.out.println("\033[31mMafias lost");

                                }

                        }

                        if (Objects.equals(list.get(cho).gettype(), "detective")) {
                                //Round begins
                                int mafias = 0;
                                int others = 0;
                                int size = list.size();
                                int sized = list.size();
                                int round = 0;
                                while (size > 0) {
                                        int[] votes = new int[n];
                                        System.out.println("ROUND " + (round) + " BEGINS");


                                        //mafia chooses a target
                                        System.out.println("Mafia chooses a target");
                                        int sum = 0;
                                        for (int i = 0; i < list.size(); i++) {
                                                if (list.get(i).gettype().equals("mafia")) {
                                                        sum = sum + list.get(i).getHP();
                                                }
                                        }
                                        Random rand = new Random();
                                        int cr = rand.ints(1, n + 1).findFirst().getAsInt();
                                        //System.out.println("mafia " + c);
                                        for (int i = 0; i < list.size(); i++) {
                                                if (cr == list.get(i).getid()) {
                                                        String s = list.get(i).gettype();
                                                        if (Objects.equals(s, "mafia")) {
                                                                if (list.get(i).getHP() < sum) {
                                                                        int vgy = list.get(i).getHP();

                                                                        list.get(i).setHP(list.get(i).getHP(), list.get(i).getHP());

                                                                }
                                                        }
                                                        if (Objects.equals(s, "healer")) {
                                                                if (list.get(i).getHP() < sum)
                                                                        list.get(i).setHP(list.get(i).getHP(), list.get(i).getHP());
                                                        }
                                                        if (Objects.equals(s, "commoner")) {
                                                                if (list.get(i).getHP() < sum)
                                                                        list.get(i).setHP(list.get(i).getHP(), list.get(i).getHP());
                                                        }
                                                }
                                        }
                                        System.out.println("Detective is testing someone ");
                                        System.out.println("Please choose someone to test");
                                        // Random random = new Random();
                                        int cc = sc.nextInt();
                                        System.out.println("Healer is selecting someone to heal");
                                        //System.out.println("mafia " + cc);
                                        for (int i = 0; i < list.size(); i++) {
                                                if (cc == list.get(i).getid()) {
                                                        String sf = list.get(i).gettype();
                                                        if (Objects.equals(sf, "mafia")) {
                                                                list.remove(list.get(i));
                                                                size--;

                                                                //healer is selecting someone
                                                                Random randomize = new Random();
                                                                int ccc = randomize.ints(1, n + 1).findFirst().getAsInt();
                                                                //System.out.println("mafia " + ccc);
                                                                for (int y = 0; y < list.size(); y++) {
                                                                        if (ccc == list.get(y).getid()) {

                                                                                list.get(y).setHP(list.get(y).getHP(), -500);

                                                                        }
                                                                }
                                                        }

                                                        if (!Objects.equals(sf, "mafia")) {
                                                                //voting
                                                                // System.out.println("Healer is selecting someone to heal");
                                                                Random randomize = new Random();
                                                                int ccc = randomize.ints(1, n + 1).findFirst().getAsInt();
                                                                // System.out.println("mafia " + ccc);
                                                                for (int y = 0; y < list.size(); y++) {
                                                                        if (ccc == list.get(y).getid()) {

                                                                                list.get(y).setHP(list.get(y).getHP(), -500);

                                                                        }
                                                                }

                                                                int max = Integer.MIN_VALUE;
                                                                for (int vo = 0; vo < list.size(); vo++) {

                                                                        while (sized >= 0) {
                                                                                Random randomized = new Random();
                                                                                int co = randomized.ints(1, n + 1).findFirst().getAsInt();
                                                                                for (int y = 0; y < list.size(); y++) {
                                                                                        if (co == list.get(y).getid()) {
                                                                                                list.get(y).setvote();
                                                                                        }
                                                                                }
                                                                                sized--;
                                                                        }


                                                                        for (int ie = 0; ie < list.size(); ie++) {
                                                                                votes[ie] = list.get(ie).getvote();
                                                                        }
                                                                        for (int ig = 0; ig < list.size(); ig++) {
                                                                                if (max < votes[ig]) {
                                                                                        max = votes[ig];
                                                                                }

                                                                        }
                                                                }


                                                                //voted out
                                                                for (int di = 0; di < list.size(); di++) {
                                                                        if (max == list.get(di).getvote()) {
                                                                                System.out.println("The player voted out is" + (di + 1));
                                                                                list.remove(list.get(di));

                                                                                break;
                                                                        }
                                                                }
                                                                size--;

                                                                //HP out
                                                                for (int fi = 0; fi < list.size(); fi++) {
                                                                        if (0 == list.get(fi).getHP()) {
                                                                                System.out.println("The player died is" + (fi + 1));
                                                                                list.remove(list.get(fi));
                                                                                // break;
                                                                        }
                                                                }
                                                                size--;
                                                        }
                                                }

                                        }
                                        //counting process
                                        for (int i = 0; i < list.size(); i++) {
                                                if (list.get(i).gettype().equals("mafia")) {
                                                        mafias = mafias + 1;
                                                } else {
                                                        others = others + 1;
                                                }
                                        }
                                        if (mafias == others || others == 0 || round > 60) {
                                                System.out.println("\033[31mGame over -");
                                                System.out.println("\033[31mMafias won");
                                                break;
                                        }

                                        round++;
                                }
                                if ((mafias != others) && round < 60) {
                                        System.out.println("\033[31mGame Over -");
                                        System.out.println("\033[31mMafias lost");

                                }
                        }

                        if (Objects.equals(list.get(cho).gettype(), "healer"))
                        {
                                //Round begins
                                int mafias=0;
                                int others=0;
                                int size=list.size();
                                int sized=list.size();
                                int round=0;
                                while(size>0) {
                                        int[] votes = new int[n];
                                        System.out.println("ROUND " + (round) + " BEGINS");


                                        //mafia chooses a target
                                        System.out.println("Mafia chooses a target");
                                        int sum = 0;
                                        for (int i = 0; i < list.size(); i++) {
                                                if (list.get(i).gettype().equals("mafia")) {
                                                        sum = sum + list.get(i).getHP();
                                                }
                                        }
                                        Random rand = new Random();
                                        int cs = rand.ints(1, n + 1).findFirst().getAsInt();
                                        // System.out.println("mafia " + c);
                                        for (int i = 0; i < list.size(); i++) {
                                                if (cs == list.get(i).getid()) {
                                                        String s = list.get(i).gettype();
                                                        if (Objects.equals(s, "detective")) {
                                                                if (list.get(i).getHP() < sum) {
                                                                        int vgy = list.get(i).getHP();

                                                                        list.get(i).setHP(list.get(i).getHP(), list.get(i).getHP());

                                                                }
                                                        }
                                                        if (Objects.equals(s, "mafia")) {
                                                                if (list.get(i).getHP() < sum)
                                                                        list.get(i).setHP(list.get(i).getHP(), list.get(i).getHP());
                                                        }
                                                        if (Objects.equals(s, "commoner")) {
                                                                if (list.get(i).getHP() < sum)
                                                                        list.get(i).setHP(list.get(i).getHP(), list.get(i).getHP());
                                                        }
                                                }
                                        }
                                        System.out.println("Detective is testing someone ");
                                        System.out.println("Healer is selecting someone to heal");
                                        // Random random = new Random();
                                        int cc = random.ints(1, n + 1).findFirst().getAsInt();
                                        //System.out.println("mafia " + cc);
                                        for (int i = 0; i < list.size(); i++) {
                                                if (cc == list.get(i).getid()) {
                                                        String sf = list.get(i).gettype();
                                                        if (Objects.equals(sf, "mafia"))
                                                        {
                                                                list.remove(list.get(i));
                                                                size--;

                                                                //healer is selecting someone
                                                                Random randomize = new Random();
                                                                System.out.println("Please choose someone to heal");
                                                                int ccc = sc.nextInt();
                                                                // System.out.println("mafia " + ccc);
                                                                for (int y = 0; y < list.size(); y++) {
                                                                        if (ccc == list.get(y).getid()) {

                                                                                list.get(y).setHP(list.get(y).getHP(), -500);

                                                                        }
                                                                }
                                                        }

                                                        if(!Objects.equals(sf, "mafia")) {
                                                                //voting
                                                                // System.out.println("Healer is selecting someone to heal");
                                                                Random randomize = new Random();
                                                                System.out.println("Please choose someone to heal");
                                                                int ccc = sc.nextInt();
                                                                // System.out.println("mafia " + ccc);
                                                                for (int y = 0; y < list.size(); y++) {
                                                                        if (ccc == list.get(y).getid()) {

                                                                                list.get(y).setHP(list.get(y).getHP(), -500);

                                                                        }
                                                                }

                                                                int max = Integer.MIN_VALUE;
                                                                for (int vo = 0; vo < list.size(); vo++) {

                                                                        while (sized >= 0) {
                                                                                Random randomized = new Random();
                                                                                int co = randomized.ints(1, n + 1).findFirst().getAsInt();
                                                                                for (int y = 0; y < list.size(); y++) {
                                                                                        if (co == list.get(y).getid()) {
                                                                                                list.get(y).setvote();
                                                                                        }
                                                                                }
                                                                                sized--;
                                                                        }


                                                                        for (int ie = 0; ie < list.size(); ie++) {
                                                                                votes[ie] = list.get(ie).getvote();
                                                                        }
                                                                        for (int ig = 0; ig < list.size(); ig++) {
                                                                                if (max < votes[ig]) {
                                                                                        max = votes[ig];
                                                                                }

                                                                        }
                                                                }



                                                                //voted out
                                                                for (int di = 0; di < list.size(); di++) {
                                                                        if (max == list.get(di).getvote()) {
                                                                                System.out.println("The player voted out is" + (di + 1));
                                                                                list.remove(list.get(di));

                                                                                break;
                                                                        }
                                                                }
                                                                size--;

                                                                //HP out
                                                                for ( int fi = 0; fi < list.size(); fi++) {
                                                                        if (0 == list.get(fi).getHP()) {
                                                                                System.out.println("The player died is" + (fi + 1));
                                                                                list.remove(list.get(fi));
                                                                                // break;
                                                                        }
                                                                }
                                                                size--;
                                                        }
                                                }

                                        }
                                        //counting process
                                        for (int i = 0; i < list.size(); i++) {
                                                if (list.get(i).gettype().equals("mafia")) {
                                                        mafias = mafias + 1;
                                                } else {
                                                        others = others + 1;
                                                }
                                        }
                                        if (mafias == others||others==0||round>60) {
                                                System.out.println("\033[31mGame over -");
                                                System.out.println("\033[31mMafias won");
                                                break;
                                        }

                                        round++;
                                }
                                if((mafias!=others)&&round<60)
                                {
                                        System.out.println("\033[31mGame Over -");
                                        System.out.println("\033[31mMafias lost");

                                } }

                        if (Objects.equals(list.get(cho).gettype(), "commoner")) {
                                //Round begins
                                int mafias = 0;
                                int others = 0;
                                int size = list.size();
                                int sized = list.size();
                                int round = 0;
                                while (size > 0) {
                                        int[] votes = new int[n];
                                        System.out.println("ROUND " + (round) + " BEGINS");


                                        //mafia chooses a target
                                        System.out.println("Mafia chooses a target");
                                        int sum = 0;
                                        for (int i = 0; i < list.size(); i++) {
                                                if (list.get(i).gettype().equals("mafia")) {
                                                        sum = sum + list.get(i).getHP();
                                                }
                                        }
                                        Random rand = new Random();
                                        int cq = rand.ints(1, n + 1).findFirst().getAsInt();
                                        // System.out.println("mafia " + c);
                                        for (int i = 0; i < list.size(); i++) {
                                                if (cq == list.get(i).getid()) {
                                                        String s = list.get(i).gettype();
                                                        if (Objects.equals(s, "detective")) {
                                                                if (list.get(i).getHP() < sum) {
                                                                        int vgy = list.get(i).getHP();

                                                                        list.get(i).setHP(list.get(i).getHP(), list.get(i).getHP());

                                                                }
                                                        }
                                                        if (Objects.equals(s, "mafia")) {
                                                                if (list.get(i).getHP() < sum)
                                                                        list.get(i).setHP(list.get(i).getHP(), list.get(i).getHP());
                                                        }
                                                        if (Objects.equals(s, "healer")) {
                                                                if (list.get(i).getHP() < sum)
                                                                        list.get(i).setHP(list.get(i).getHP(), list.get(i).getHP());
                                                        }
                                                }
                                        }
                                        System.out.println("Detective is testing someone ");
                                        System.out.println("Healer is selecting someone to heal");
                                        // Random random = new Random();
                                        int cc = random.ints(1, n + 1).findFirst().getAsInt();
                                        //System.out.println("mafia " + cc);
                                        for (int i = 0; i < list.size(); i++) {
                                                if (cc == list.get(i).getid()) {
                                                        String sf = list.get(i).gettype();
                                                        if (Objects.equals(sf, "mafia")) {
                                                                list.remove(list.get(i));
                                                                size--;

                                                                //healer is selecting someone
                                                                Random randomize = new Random();
                                                                int ccc = randomize.ints(1, n + 1).findFirst().getAsInt();
                                                                // System.out.println("mafia " + ccc);
                                                                for (int y = 0; y < list.size(); y++) {
                                                                        if (ccc == list.get(y).getid()) {

                                                                                list.get(y).setHP(list.get(y).getHP(), -500);

                                                                        }
                                                                }
                                                        }

                                                        if (!Objects.equals(sf, "mafia")) {
                                                                //voting
                                                                // System.out.println("Healer is selecting someone to heal");
                                                                Random randomize = new Random();
                                                                int ccc = randomize.ints(1, n + 1).findFirst().getAsInt();
                                                                //  System.out.println("mafia " + ccc);
                                                                for (int y = 0; y < list.size(); y++) {
                                                                        if (ccc == list.get(y).getid()) {

                                                                                list.get(y).setHP(list.get(y).getHP(), -500);

                                                                        }
                                                                }

                                                                int max = Integer.MIN_VALUE;
                                                                System.out.println("Please vote your choice");
                                                                int ye = sc.nextInt();
                                                                for (int ed = 0; ed < 1; ed++) {
                                                                        if (ye == list.get(ed).getid()) {
                                                                                list.get(ed).setvote();
                                                                                // break;
                                                                        }
                                                                }
                                                                for (int vo = 0; vo < list.size(); vo++) {


                                                                        while (sized >= 0) {
                                                                                Random randomized = new Random();
                                                                                int co = randomized.ints(1, n + 1).findFirst().getAsInt();

                                                                                for (int y = 0; y < list.size() - 1; y++) {
                                                                                        if (co == list.get(y).getid()) {
                                                                                                list.get(y).setvote();
                                                                                        }
                                                                                }
                                                                                sized--;
                                                                        }


                                                                        for (int ie = 0; ie < list.size(); ie++) {
                                                                                votes[ie] = list.get(ie).getvote();
                                                                        }
                                                                        for (int ig = 0; ig < list.size(); ig++) {
                                                                                if (max < votes[ig]) {
                                                                                        max = votes[ig];
                                                                                }

                                                                        }
                                                                }


                                                                //voted out
                                                                for (int di = 0; di < list.size(); di++) {
                                                                        if (max == list.get(di).getvote()) {
                                                                                System.out.println("The player voted out is" + (di + 1));
                                                                                list.remove(list.get(di));

                                                                                break;
                                                                        }
                                                                }
                                                                size--;

                                                                //HP out
                                                                for (int fi = 0; fi < list.size(); fi++) {
                                                                        if (0 == list.get(fi).getHP()) {
                                                                                System.out.println("The player died is" + (fi + 1));
                                                                                list.remove(list.get(fi));
                                                                                // break;
                                                                        }
                                                                }
                                                                size--;
                                                        }
                                                }

                                        }
                                        //counting process
                                        for (int i = 0; i < list.size(); i++) {
                                                if (list.get(i).gettype().equals("mafia")) {
                                                        mafias = mafias + 1;
                                                } else {
                                                        others = others + 1;
                                                }
                                        }
                                        if (mafias == others || others == 0 || round > 60) {
                                                System.out.println("\033[31mGame over -");
                                                System.out.println("\033[31mMafias won");
                                                break;
                                        }

                                        round++;
                                }
                                if ((mafias != others) && round < 60) {
                                        System.out.println("\033[31mGame Over -");
                                        System.out.println("\033[31mMafias lost");

                                }
                        }
                }
                //for testing purpose
                for (int i = 0; i < record.size(); i++) {

                        System.out.print("\033[30mPlayer" + (i + 1) + "  " + "was a  " + record.get(i).gettype()+" , ");
                }
        }
}

