# Ödev Soruları

## Not: Tüm soruları tek bir Java projesi içinde çözüp gönderebilirsiniz.

**Açıklama1:** Soruların her biri ayrı ayrı algoritmaları ifade eder. Algoritma dediğimiz kavram bilgisayar programcılığı için çok önemli bir konudur.
Algoritma düşünce sistematiğini geliştirmeyen bir yazılımcı yazılım kütüphanelerini, programlama dillerini öğrenerek iyi bir programcı olma yolunda çok ileriye gidemez.

**Açıklama2:** Bu önemine istinaden ekstra algoritma ödevleriyle bu sizlerin bu yönünü geliştirmek hedefindeyiz.

**Açıklama3:** Verilen soruları Java dilinde kodlamanızı rica ediyorum. Ayrıca, hazır çözümler kullanmadan herkesin bireysel kodlamalasını rica ediyorum.
Yardımlaşma için birbirinizden ve benden yardım alabilirsiniz. Tek şart copy-paste kodlar lütfen olmasın :) Sizin gelişiminiz için bu çok önemlidir.

**Açıklama4:** Ödev sorularını yaparken takıldığınız yerlerde Google'da aramalar yaparak yardım alabilirsiniz. Unutmayın Google en büyük yardımcınız :)

#Sorular

**Soru1:** 1'den 10000 (10 bin)'e kadar olan sayılardan oluşan bir ArrayList oluşturunuz. Ardından, bu ArrayList'teki 10 bin elemanı 2500 eleman olacak şekilde 4 eşit parçaya ayırınız. Bu 4 ayrı 2500 elemanlık ArrayList'ler içinde tek ve çift sayıları bulan 4 ayrı Thread tasarlayınız. 

* 4 Thread bulduğu çift sayıları ortak bir ArrayList'e ekleyecektir.
* 4 Thread bulduğu tek sayıları ortak bir ArrayList'e ekleyecektir.
* Tek ve çift sayıları tutan ArrayList'ler ilk oluşturulduklarında boş olacaklardır. Ve iki tane ArrayList olacaklardır.
* 4 Thread kendine ait 2500 elemanlık ArrayList'i işlemeye başlayınca tek ve çift sayı ArrayList'lerini dolduracaktır.


**Soru2:** "chapter-4-database-operations" isminde JDBC API kullanarak MySQL veritabanı ile haberleşen bir program hazırlanmıştır. Programda işlem menüleri vardır. İşlem menüsünü kullanarak çalışan kayıtlarını çekebilmek, çalışan profilini görüntülemek, yeni çalışan ekleyebilmek, güncelleyebilmek ve silebilmek gibi işlemler mümkündür. Bu özelliklerin hepsi kodlanmıştır. Programda eksik olan özellikler bulunmaktadır. Bu eksik özellikleri sizin kodlamanız gerekmektedir. Eksik olan kod blokları içinde açıklama satırlarında detaylar bulunmaktadır. Ayrıca eksik olan kısımlar aşağıda maddeler halinde listelenmiştir. Her madde için kod yazmanız gerekmektedir.

Not: Öncelikle uygulmayı çalıştırınız ve nasıl çalıştığını gözlemleyiniz. Ardından, kodları inceleyiniz.
Not: Uygulamayı çalıştırmak için "db.connection.mysql" paketi altındaki "Application.java" sınıfını sağ tıklayıp çalıştırabilirsiniz.

Ödev olarak yapılması gereken maddeler:

* DepartmentDAO sınıfı içindeki "getAll" fonksiyonunda tüm departmanları veri tabanından sorgulayan kodu yazınız. Detaylar ilgili sınıfın içinde yer alıyor.

* Ardından, DepartmentService sınıfında veritabanından aldığınız kayıtları döndüren bir fonksiyon tasarlayınız.

* ManagerDAO sınıfındaki "loadAllActiveManagers" fonksiyonunda veritabanına sorgu atıp aktif olarak yöneticilik yapan kişileri listeleyen kodları yazınız.

* Ardından, ManagerService sınıfı içinde aktif olarak yöneticilik yapanların listesini döndüren bir fonksiyon yazınız.

* Application sınıfı içinde menüde boş bırakılan işlemler bulunmaktadır. 7 ve 8 nolu işlemleri çalışacak şekilde doldurunuz.
