from tensorflow.keras.models import load_model
import os
from deep_learning_pipeline import Model_Pipeline

model = load_model(os.path.join('model', 'water_problem_classifier.h5'))
pipeline = Model_Pipeline()
pipeline.predict(model)