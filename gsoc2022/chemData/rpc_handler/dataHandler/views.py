import grpc
from django.http import JsonResponse, HttpResponse
import molecule_pb2
import molecule_pb2_grpc
from google.protobuf import json_format
from django.views.decorators.csrf import csrf_exempt


# READ METHOD: Read the molecule data with an object ID.
def readMoleculeData(channel):
    stub = molecule_pb2_grpc.MoleculeServiceStub(channel)
    rpc_log = stub.ReadMolecule(
        molecule_pb2.ReadMoleculeRequest(id="63427834abcb608bf0b4c1c3")
    )
    return rpc_log

def GetMoleculeData(channel):
    stub = molecule_pb2_grpc.MoleculeServiceStub(channel)
    rpc_log = stub.GetMolecule(molecule_pb2.GetMoleculeRequest())
    value_iterator = rpc_log.values()[0]
    data_type = type(rpc_log)
    print(data_type)
    return json_format.MessageToJson(value_iterator)
    #return json_format.MessageToJson(rpc_log)

# LIST METHOD: Read the molecule data as a stream.
def ListmoleculeData(channel):
    stub = molecule_pb2_grpc.MoleculeServiceStub(channel)
    rpc_log = stub.ListMolecule(molecule_pb2.ListMoleculeRequest())
    data_log = []

    for molData in rpc_log:
        data = {
            "mol_id": molData.molecule._id,
            "doi": molData.molecule.doi,
            "published_date": molData.molecule.published_date,
            "title": molData.molecule.titleu

        }
        data_log.append(data)
    return data_log


@csrf_exempt
def client(request):
    if request.method == "GET":
        print(request)
        with grpc.insecure_channel("localhost:50051") as channel:
            # Return the JSON Object stream
            # return (ListmoleculeData(channel))
            return HttpResponse(GetMoleculeData(channel))

            # Return the HTTP response
            # return HttpResponse(readMoleculeData(channel))
