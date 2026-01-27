🛡️ SentinelBank - Real-Time Fraud Detection Simulator
SentinelBank, bankacılık işlemlerinde "Impossible Travel" (İmkansız Yolculuk) senaryolarını tespit etmek için geliştirilmiş, Java Spring Boot tabanlı bir güvenlik simülasyonudur.

Bu proje, kullanıcıların işlem konumlarını (Geolocation) analiz eder ve fiziksel olarak mümkün olmayan hızlarda gerçekleşen (örneğin: 1 dakika içinde Rize'den New York'a gitmek gibi) işlemleri Haversine Formülü kullanarak tespit edip bloklar.

Kullanılan Teknolojiler ve Mimari
Bu proje, modern yazılım geliştirme prensiplerine uygun olarak Full-Stack bir yaklaşımla geliştirilmiştir. Kullanılan temel teknolojiler ve kullanım amaçları şunlardır:

 Backend (Java & Spring Boot)

Projenin omurgası, endüstri standardı olan Java 17 ve Spring Boot 3 framework'ü üzerine kurulmuştur.

RESTful API: Frontend ile haberleşmek için RiskController üzerinden JSON tabanlı veri akışı sağlanmıştır.

Service Layer Pattern: İş mantığı (Business Logic), SecurityService ve CityService sınıfları ile modüler hale getirilmiştir.

Algoritmik Hesaplama: İki coğrafi koordinat arasındaki kuş uçuşu mesafeyi hesaplamak için matematiksel Haversine Formülü Java'ya uyarlanmıştır.

 Frontend (HTML5, CSS3, JavaScript)

Kullanıcı deneyimini artırmak için Modern Cyberpunk/Dark UI tasarım dili kullanılmıştır.

Leaflet.js: İşlemleri dünya haritası üzerinde dinamik olarak görselleştirmek ve rota çizmek için açık kaynaklı harita kütüphanesi kullanılmıştır.

Fetch API: Backend'e asenkron istekler (Async/Await) atarak sayfa yenilenmeden verilerin güncellenmesi sağlanmıştır.

CSS Animations: Alarm durumlarında (Fraud Detection) kullanıcıyı uyaran neon efektli animasyonlar eklenmiştir.

🛠️ Araçlar ve Yapılandırma

Maven: Proje bağımlılıklarını yönetmek ve build almak için kullanılmıştır.

Lombok: Java sınıflarında boilerplate (tekrar eden) kodları azaltmak için entegre edilmiştir.

🌍 Nasıl Çalışır? (Senaryo Modu)
Simülasyon, gerçekçi bir Dünya Turu Senaryosu üzerinden ilerler:

Başlangıç: Sistem, rastgele bir sehirden ve ulkesinden lokasyonundan başlar.

İşlem Talebi: Kullanıcı "İşlem Üret" butonuna bastığında, sistem önceden tanımlı rota üzerindeki bir sonraki şehre (Örn: İstanbul, Berlin, New York) sanal bir işlem gönderir.

Risk Analizi:

Önceki işlem ile yeni işlem arasındaki Mesafe (km) ve Zaman (saat) farkı hesaplanır.

Eğer hesaplanan hız, bir ticari uçağın hızını (800 km/s) aşıyorsa, sistem 🚨 FRAUD (Dolandırıcılık) alarmı verir.

Makul bir seyahat ise ✅ GÜVENLİ olarak işaretlenir.

Görselleştirme: Sonuç, harita üzerinde Yeşil (Güvenli) veya Kırmızı (Tehlikeli) çizgilerle anlık olarak çizilir.