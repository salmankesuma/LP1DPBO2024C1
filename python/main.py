class Dpr:
    # private atribut
    __id = ""
    __nama = ""
    __bidang = ""
    __partai = ""

    # konstruktor
    def __init__(self, id="", nama="", bidang="", partai=""):
        self.__id = id
        self.__nama = nama
        self.__bidang = bidang
        self.__partai = partai

    # setter dan getter
    def setId(self, id):
        self.__id = id

    def setNama(self, nama):
        self.__nama = nama

    def setBidang(self, bidang):
        self.__bidang = bidang

    def setPartai(self, partai):
        self.__partai = partai

    def getId(self):
        return self.__id

    def getNama(self):
        return self.__nama

    def getBidang(self):
        return self.__bidang

    def getPartai(self):
        return self.__partai


class Main:
    llist = []  # list
    while True:
        # tampilan menu
        print("Masukan Perintah Berupa Angka!")
        print("1. Tambah DPR")
        print("2. Ubah DPR")
        print("3. Hapus DPR")
        print("4. Tampilkan Daftar DPR")
        print("5. SELESAI\n")
        n = int(input())

        if n == 1:  # tambah data DPR
            id = input("Masukan Id\n")
            nama = input("Masukan Nama\n")
            bidang = input("Masukan Bidang\n")
            partai = input("Masukkan Partai\n")

            temp = Dpr()
            temp.setId(id)
            temp.setNama(nama)
            temp.setBidang(bidang)
            temp.setPartai(partai)

            llist.append(temp)

        elif n == 2:  # ubah data DPR
            id = input("Masukkan NIM mahasiswa yang ingin diubah\n")
            found = False
            for i, data in enumerate(llist):
                if data.getId() == id:  # jika Id sesuai maka dapat diubah
                    found = True
                    id = input("Masukkan NIM baru\n")
                    nama = input("Masukkan Nama baru\n")
                    bidang = input("Masukkan Program Studi baru\n")
                    partai = input("Masukkan Fakultas baru\n")
                    # set atribut baru
                    llist[i].setId(id)
                    llist[i].setNama(nama)
                    llist[i].setBidang(bidang)
                    llist[i].setPartai(partai)
            if not found:
                print(f"Mahasiswa dengan Id {id} tidak ditemukan")

        elif n == 3:  # hapus data Dpr
            found = False
            id = input("Masukkan  ID DPR yang ingin dihapus\n")
            for i, data in enumerate(llist):
                if data.getId() == id:
                    found = True
                    print(f"DPR dengan ID {id} berhasil dihapus")
                    llist.pop(i)
                    break
            if not found:
                print(f"Mahasiswa dengan ID {id} tidak ditemukan")

        elif n == 4:  # Menampilkan daftar DPR
            print("Daftar DPR:")
            print("ID\tNama\tBidang\tPartai")
            for i, data in enumerate(llist):
                print(
                    f"{data.getId()}\t{data.getNama()}\t{data.getBidang()}\t{data.getPartai()}")

        elif n == 5:  # keluar dari program
            print("Terima Kasih, Sampai jumpa kembali")
            break

        else:  # perintah tidak valid dengan menu
            print("Perintah tidak valid")