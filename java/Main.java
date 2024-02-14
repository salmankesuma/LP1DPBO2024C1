import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

class Dpr{
    
    //privat atribut
    private    int id;
    private    String nama;
    private    String bidang;
    private    String partai;

    //konstruktor
    public Dpr(){
        this.id = 0;
        this.nama = "";
        this.bidang = "";
        this.partai = "";
    }

    public Dpr(int id, String nama, String bidang, String partai){
        this.id = id;
        this.nama = nama;
        this.bidang = bidang;
        this.partai = partai;
    }

    //setter dan getter
    int getId(){
        return this.id;
    }

    void setId(int id){ 
        this.id=id;
    }

    String getNama(){
        return this.nama;
    }

    void setNama(String nama){
        this.nama = nama;
    }

    String getBidang(){
        return this.bidang;
    }

    void setBidang(String bidang){
        this.bidang=bidang;
    }

    String getPartai(){
        return this.partai;
    }

    void setPartai(String partai){
        this.partai = partai;
    }
}

class Main{
    public static void main(String[] args){
        
        List<Dpr> llist = new ArrayList<Dpr>(); //Membuat List
        int n = 0;

        //variabel atribut
        int id;
        String nama;
        String bidang;
        String partai;

        do{
            Dpr temp = new Dpr();

            //Tampilan Menu
            System.out.println("Masukan Perintah Berupa Angka!");
            System.out.println("1. Tambah DPR");
            System.out.println("2. Ubah DPR");
            System.out.println("3. Hapus DPR");
            System.out.println("4. Tampilkan Daftar DPR");
            System.out.println("5. Selesai\n");

            Scanner input = new Scanner(System.in);
            n = input.nextInt();

            if (n == 1) // jika masukan == 1 maka tambah data mahasiswa 
            {
                System.out.println("Masukan id");
                id = input.nextInt();
                System.out.println("Masukan Nama");
                nama = input.next();
                System.out.println("Masukan Program Bidang");
                bidang = input.next();
                System.out.println("Masukkan Partai");
                partai = input.next();

                temp.setId(id);
                temp.setNama(nama);
                temp.setBidang(bidang);
                temp.setPartai(partai);
    
                llist.add(temp);
                System.out.println("Data Berhasil dimasukan\n");
            }else if (n == 2)// jika masukan == 2 maka ubah/edit data 
            {
                System.out.println("Masukkan Id Dpr yang ingin diubah");
                id = input.nextInt();
                boolean found = false;
                
                for (Dpr dpr : llist) {
                    if (dpr.getId() == id) // jika memasukan NIM sesuai maka dapat mengubah data
                    {
                        found = true;
                        System.out.println("Masukkan Id baru");
                        id = input.nextInt();
                        System.out.println("Masukkan Nama baru");
                        nama = input.next();
                        System.out.println("Masukkan Bidang baru");
                        bidang = input.next();
                        System.out.println("Masukkan Partai baru");
                        partai = input.next();
                        //set atribut baru
                        dpr.setId(id);
                        dpr.setNama(nama);
                        dpr.setBidang(bidang);
                        dpr.setPartai(partai);
                    }
                }
                if (!found) // jika id tidak ada yg sesuai
                {
                    System.out.println("DPR dengan Id " + id + " tidak ditemukan");
                }
            }else if (n == 3) // jika masukan == 3 maka hapus data Id
            {
                boolean found = false;
                System.out.println("Masukkan Id Dpr yang ingin dihapus");
                id = input.nextInt();
                for(Dpr dpr : llist)
                {
                    if (dpr.getId() == id) // jika id sesuai dengan yg ada di daftar maka akan melakukan proses hapus
                    {
                        found = true;
                        System.out.println("DPR dengan Id " + id + " berhasil dihapus\n");
                        llist.remove(dpr);
                        break;
                    }
                }
                if (!found) // jika NIM tidak ada yg sesuai
                {
                    System.out.println("DPR dengan ID " + id + " tidak ditemukan");
                }
                
            }else if (n == 4) // jika masukan == 4 maka akan menampilkan daftar DPR
            {
                System.out.println("Daftar DPR:");
                System.out.println("ID\tNama\tBidang\tPartai");
                for (Dpr dpr : llist) {
                    System.out.println(dpr.getId() + "\t" + dpr.getNama() + "\t" + dpr.getBidang() + "\t" + dpr.getPartai());
                }
            }else if(n > 5) // jika masukan tidak sesuai dengan menu yg disediakan maka invalid
            {
                System.out.println("Perintah Tidak Valid"); 
            }
        
        }while (n != 5);//menu exit
        
        System.out.println("Terima Kasih");
    }
}