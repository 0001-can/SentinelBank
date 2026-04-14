# SentinelBank/intelligence-python/scripts/risk_analyzer.py
from flask import Flask, request, jsonify
import numpy as np

app = Flask(__name__)

@app.route('/predict_risk', methods=['POST'])
def predict_risk():
    data = request.json
    amount = data.get('amount')
    location = data.get('location')
    
    risk_score = 0
    
    # Eğer işlem miktarı 10.000 TL üzerindeyse risk artar
    if amount > 10000:
        risk_score += 40
        
    # Eğer şehir 'Amsterdam' ise ve kullanıcı Rize'de yaşıyorsa (Java bunu bildirecek)
    if location == 'Amsterdam':
        risk_score += 50
        
    response = {
        "risk_score": risk_score,
        "verdict": "BLOCK" if risk_score > 80 else "ALLOW"
    }
    
    return jsonify(response)

if __name__ == '__main__':
    app.run(port=5000)
