<?php

class Dpr {
    //private atribut
    private $id;
    private $nama;
    private $bidang;
    private $paartai;
    
    //konstruktor
    public function __construct($id, $nama, $bidang, $partai) {
        $this->id = $id;
        $this->nama = $nama;
        $this->bidang = $bidang;
        $this->partai = $partai;
        
    }
    
    //setter dan getter
    public function getNama() {
        return $this->nama;
    }
    
    public function setNama($nama) {
        $this->nama = $nama;
    }
    
    public function getId() {
        return $this->id;
    }
    
    public function setId($id) {
        $this->$id = $id;
    }
    
    public function getBidang() {
        return $this->bidang;
    }
    
    public function setBidang($bidang) {
        $this->bidang = $bidang;
    }
    
    public function getPartai() {
        return $this->partai;
    }
    
    public function setPartai($partai) {
        $this->partai = $partai;
    }
    
    public function getFotoProfil() {
        return $this->foto_profil;
    }
    

}

class DaftarDpr {
    private $dpr = array();
    //fungsi tambah data dpr
    public function tambahDpr($id, $nama,  $bidang, $partai) {
        $dpr_baru = new Dpr($id, $nama, $bidang, $partai);
        $this->dpr[] = $dpr_baru;
    }
    
    //fungsi ubah data DPR
    public function ubahDpr($id_lama, $id_baru, $nama_baru, $bidang_baru, $partai_baru) {
        foreach ($this->dpr as $dpr) {
            if ($dpr->getId() == $id_lama) //jika Id sesuai dengan daftar maka dapat diubah
            {   
                //set atribut baru
                $dpr->setId($id_baru);
                $dpr->setNama($nama_baru);
                $dpr->setBidang($bidang_baru);
                $dpr->setPartai($partai_baru);
                break;
            }
        }
    }
    
    //fungsi hapus data DPR
    public function hapusDpr($id) {
        foreach ($this->dpr as $key => $dpr) 
        {
            //jika NIM sesuai dengan daftar maka dapat dihapus
            if ($dpr->getId() == $id) {
                unset($this->dpr[$key]);
                break;
            }
        }
        $this->dpr = array_values($this->dpr);
    }
    
    //fungsi menampilkan daftar dpr
    public function tampilDaftarDpr() {
        foreach ($this->dpr as $dpr) {
            echo "ID: " . $dpr->getId() . "<br>";
            echo "Nama: " . $dpr->getNama() . "<br>";
            echo "Bidang: " . $dpr->getBidang() . "<br>";
            echo "Partai: " . $dpr->getPartai() . "<br>";
            echo "<br>";
            }
        }
}

//membuat variabel untuk data mahasiswa
$daftar_dpr = new DaftarDpr();

//melakukan tambah data
$daftar_dpr->tambahDpr("2024", "Jokowi Gibran",  "Bendaraha", "PDIP");
$daftar_dpr->tambahDpr("2025", "naruto sasuke",  "Sistem Logistik", "PSI");

//menampilkan daftar dpr
echo "Daftar DPR Sebelum Diubah/Hapus:<br>";
$daftar_dpr->tampilDaftarDpr();
echo "<br>";

//melakukan ubah data sesuai dengan kata kunci id
$daftar_dpr->ubahDpr("2024", "1945", "Prabowo Saepuloh", "sekratatis", "PAN");
//menampilkan daftar DPR
echo "Daftar DPR Setelah Diubah:<br>";
$daftar_dpr->tampilDaftarDpr();
echo "<br>";

//melakukan hapus data
$daftar_dpr->hapusDpr("2025");
//menampilkan daftar mahasiswa
echo "Daftar Mahasiswa Setelah Dihapus:<br>";
$daftar_dpr ->tampilDaftarDpr();
echo "<br>";

?>