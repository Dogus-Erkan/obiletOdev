# Obilet Mobil Test Ödevi

Bu proje, Obilet ödev uygulamasının mobil senaryolarını test etmek için tasarlanmıştır.

## Başlangıç

Projeyi yerel geliştirme ortamınıza kurmak için aşağıdaki adımları izleyin.

### Gereksinimler

- **Java JDK 8** veya üzeri
- **Maven**: Bağımlılıkları yönetmek için
- **Selenium WebDriver**: Tarayıcı testleri için
- **Appium**: Mobil uygulama testleri için
- **Gauge**: Test senaryolarını oluşturmak ve yönetmek için

# Test Senaryoları

## 1. Yeni Üyelik Oluşturulması

1. Uygulama açılır. Uygulamanın doğru şekilde açıldığı kontrol edilir.
2. Alt sekmelerden Hesabım sekmesi tıklanır.
3. Üye girişi yapın butonu tıklanır. Giriş yap ekranı açıldığı doğrulanır.
4. Hemen Üye Ol Text tıklanır. Mail ve Password alanı girilerek üye ol butonuna tıklanır.
5. Hesabım sayfası açılır ve sayfanın doğru şekilde açıldığı kontrol edilir.
6. Alt sekmeden Ara butonuna tıklanır. Anasayfasının açıldığı doğrulanır.

## 2. Otobüs Bileti Checkout Adımına Gitme

1. Obilet ana sayfasına girilerek üst dikeylerden Otobüs tabine tıklanır ve Otobüs arama sayfasının açıldığı görülür.
2. Search alanının geldiği görüntülenir.
3. Nereden tıklanıp Prag araması yapılıp seçilmelidir.
4. Nereye tıklanıp Berlin araması yapılıp seçilmelidir.
5. Gidiş Tarih alanı görüntülenip Takvimin açıldığı görüntülenir *X bi tarih seçilmelidir*.
6. Otobüs listeleme sayfası açıldığı görüntülenir.
7. Listeleme sayfasında seferlerin geldiği görüntülenir.
8. Listeleme sayfasında *X bi seferi seçip Branded Fare alanının açıldığı görüntülenir*.
9. *X bi Branded Fare* de Koltuk adeti + ile 2 kişi yapılır.
10. Seçilmek istenen Branded Fare tıklanır.
11. Checkout sayfası açıldığı doğrulanır.

### Kurulum

1. Projeyi yerel makinenize klonlayın:

    ```bash
    git clone https://github.com/Dogus-Erkan/obiletOdev.git
    ```

2. Proje dizinine gidin:

    ```bash
    cd proje_yolu
    ```

3. Gerekli bağımlılıkları yükleyin:

    ```bash
    mvn clean install
    ```