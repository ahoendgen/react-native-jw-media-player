require 'json'

package = JSON.parse(File.read('../package.json'))

Pod::Spec.new do |s|
  s.name         = package['name']
  s.version      = package['version']
  s.summary      = package['description']
  s.license      = package['license']

  s.authors      = package['author']
  s.homepage     = package['homepage']
  s.platform     = :ios, "9.0"

  s.source       = { :git => "https://github.com/chaimPaneth/react-native-jw-media-player.git", :tag => "v#{s.version}" }
  s.source_files = 'RNJWPlayer*.{h,m}'
  s.resources    = "Assets/*.png"
  s.dependency   'JWPlayer-SDK'
  s.dependency   'google-cast-sdk', '~> 4.3'
  s.dependency   'React'
  
  s.info_plist = {
    'NSBluetoothAlwaysUsageDescription' => 'We will use your Bluetooth for media casting.',
    'NSBluetoothPeripheralUsageDescription' => 'We will use your Bluetooth for media casting.'
  }
end
