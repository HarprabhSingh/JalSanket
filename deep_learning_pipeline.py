from tensorflow.keras.models import load_model
import os
from deep_learning_pipeline import Model_Pipeline
import json

model = load_model(os.path.join('model', 'water_problem_classifier.h5'))
pipeline = Model_Pipeline()
answer = pipeline.predict(model)



def get_json():
    temp = {"result": answer}
    return temp
# file_name = 'temp.json'
#
# with open(file_name, "w") as json_file:
#     json.dump(temp, json_file)
# print('Data Written to Json file.')
# print(type(os.path.join('temp.json')))
